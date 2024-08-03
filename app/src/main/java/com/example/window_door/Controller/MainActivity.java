package com.example.window_door.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import  com.example.window_door.Model.CostCalculator;
import  com.example.window_door.Model.Material;
import com.example.window_door.Model.Window;
import com.example.window_door.R;

public class MainActivity extends AppCompatActivity {

    private RadioGroup typeGroup;
    private LinearLayout windowOptions;
    private RadioGroup windowTypeGroup;
    private RadioGroup windowShapeGroup;
    private EditText widthInput;
    private EditText heightInput;
    private EditText materialPriceInput;
    private TextView resultText;
    private Button calculateButton;
    private EditText perimeterOffsetInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeGroup = findViewById(R.id.type_group);
        windowOptions = findViewById(R.id.window_options);
        windowTypeGroup = findViewById(R.id.window_type_group);
        windowShapeGroup = findViewById(R.id.window_shape_group);
        widthInput = findViewById(R.id.width_input);
        heightInput = findViewById(R.id.height_input);
        materialPriceInput = findViewById(R.id.material_price_input);
        resultText = findViewById(R.id.result_text);
        calculateButton = findViewById(R.id.calculate_button);
        perimeterOffsetInput = findViewById(R.id.perimeter_offset_input);

        typeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.window_option) {
                    windowOptions.setVisibility(View.VISIBLE);
                } else {
                    windowOptions.setVisibility(View.GONE);
                }
            }
        });

        windowShapeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.square_option) {
                    heightInput.setVisibility(View.GONE);
                } else {
                    heightInput.setVisibility(View.VISIBLE);
                }
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotalPrice();
            }
        });
    }

    private void calculateTotalPrice() {
        try {
            double width = Double.parseDouble(widthInput.getText().toString());
            double height = 0;
            if (heightInput.getVisibility() == View.VISIBLE) {
                height = Double.parseDouble(heightInput.getText().toString());
            }

        double materialPrice = Double.parseDouble(materialPriceInput.getText().toString());
        double perimeterOffset = Double.parseDouble(perimeterOffsetInput.getText().toString());
        boolean isDoublePanel = windowTypeGroup.getCheckedRadioButtonId() == R.id.double_panel_option;
        boolean isSquare = windowShapeGroup.getCheckedRadioButtonId() == R.id.square_option;
        boolean isSinglePanel = windowTypeGroup.getCheckedRadioButtonId() == R.id.double_panel_option;

        Material material = new Material("Custom Material", materialPrice);
        Window window = new Window(width, height, material, isDoublePanel, isSquare,isSinglePanel,perimeterOffset);

        double totalPrice = CostCalculator.calculateTotalPrice(window);

        resultText.setText("Total Price: $" + totalPrice);
        resultText.setVisibility(View.VISIBLE);
            resultText.setVisibility(View.VISIBLE);
        } catch (NumberFormatException e) {
            resultText.setText("Please enter valid numbers");
            resultText.setVisibility(View.VISIBLE);
        }
    }
}

