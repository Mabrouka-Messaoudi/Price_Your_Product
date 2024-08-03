package com.example.window_door.Model;

public class Window {
    private double width;
    private double height;
    private Material material;
    private boolean isDoublePanel;
    private boolean isSquare;
    private boolean isSinglePanel;
    private double perimeterOffset;

    public Window(double width, double height, Material material, boolean isDoublePanel, boolean isSquare,boolean
                   isSinglePanel,double perimeterOffset) {
        this.width = width;
        this.height = height;
        this.material = material;
        this.isDoublePanel = isDoublePanel;
        this.isSquare = isSquare;
        this.isSinglePanel=isSinglePanel;
        this.perimeterOffset = perimeterOffset;

    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Material getMaterial() {
        return material;
    }

    public boolean isDoublePanel() {
        return isDoublePanel;
    }

    public boolean isSquare() {
        return isSquare;
    }
    public boolean isSinglePanel() {
        return isSinglePanel;
    }
    public double getPerimeterOffset() {
        return perimeterOffset;
    }
}
