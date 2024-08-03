package com.example.window_door.Model;

public class Material {
    private String name;
    private double pricePerMeter;

    public Material(String name, double pricePerMeter) {
        this.name = name;
        this.pricePerMeter = pricePerMeter;
    }

    public String getName() {
        return name;
    }

    public double getPricePerMeter() {
        return pricePerMeter;
    }
}
