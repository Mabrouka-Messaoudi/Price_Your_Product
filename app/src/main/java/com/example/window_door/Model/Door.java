package com.example.window_door.Model;

public class Door {
    private double width;
    private double height;
    private Material material;

    public Door(double width, double height, Material material) {
        this.width = width;
        this.height = height;
        this.material = material;
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
}
