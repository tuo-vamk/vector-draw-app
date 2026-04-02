package com.vectordraw;

public class Circle implements Drawable, CanCalculateArea {

    private ShapeProperties props;
    private double radius;

    public Circle(double radius, String color, boolean transparent) {
        this.props = new ShapeProperties(color, transparent);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle [" + props + "]");
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
