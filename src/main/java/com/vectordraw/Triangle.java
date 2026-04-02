package com.vectordraw;

public class Triangle implements Drawable, CanCalculateArea {

    private ShapeProperties props;
    private double base;
    private double height;

    public Triangle(double base, double height, String color, boolean transparent) {
        this.props = new ShapeProperties(color, transparent);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle [" + props + "]");
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
