package com.vectordraw;

public class Rectangle implements Drawable, CanCalculateArea {

    private ShapeProperties props;
    private double width;
    private double height;

    public Rectangle(double width, double height, String color, boolean transparent) {
        this.props = new ShapeProperties(color, transparent);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle [" + props + "]");
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
