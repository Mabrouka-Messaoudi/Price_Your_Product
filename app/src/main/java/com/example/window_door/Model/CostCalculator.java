package com.example.window_door.Model;

public class CostCalculator {

    public static double calculatePerimeter(Window window) {
        double perimeter;
        if (window.isSquare() ) {
            perimeter = 4 * window.getWidth();
        } else {
            perimeter = 2 * (window.getWidth() + window.getHeight());
        }
        if (window.isDoublePanel()) {
            perimeter += 2 * window.getHeight();
        }
        if (window.isDoublePanel() && (window.isSquare()) ) {
            perimeter += 2 * window.getWidth(); }


        perimeter += window.getPerimeterOffset();
        return perimeter;
    }

    public static double calculateTotalPrice(Window window) {
        double perimeter = calculatePerimeter(window);
        return perimeter * window.getMaterial().getPricePerMeter();
    }
}
