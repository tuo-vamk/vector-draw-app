package com.vectordraw;

public class Triangle implements Shape, CanCalculateArea {

    private ShapeProperties props;
    private double base;
    private double height;

    public Triangle(double base, double height, String color, boolean transparent) {
        this.props = new ShapeProperties(color, transparent);
        this.base = base;
        this.height = height;
    }

    @Override public String getColor() { return props.getColor(); }
    @Override public void setColor(String color) { props.setColor(color); }
    @Override public boolean isTransparent() { return props.isTransparent(); }
    @Override public void setTransparent(boolean transparent) { props.setTransparent(transparent); }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle..");
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
