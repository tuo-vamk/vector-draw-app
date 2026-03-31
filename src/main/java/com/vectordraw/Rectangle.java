package com.vectordraw;

public class Rectangle extends Shape implements CanCalculateArea {

    private double width;
    private double height;

    public Rectangle(double width, double height, String color, boolean transparent) {
        super(color, transparent);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle..");
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
