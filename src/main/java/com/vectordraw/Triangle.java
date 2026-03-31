package com.vectordraw;

public class Triangle extends Shape implements CanCalculateArea {

    private double base;
    private double height;

    public Triangle(double base, double height, String color, boolean transparent) {
        super(color, transparent);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle..");
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
