package com.vectordraw;

public class Circle implements Shape, CanCalculateArea {

    private ShapeProperties props;
    private double radius;

    public Circle(double radius, String color, boolean transparent) {
        this.props = new ShapeProperties(color, transparent);
        this.radius = radius;
    }

    @Override public String getColor() { return props.getColor(); }
    @Override public void setColor(String color) { props.setColor(color); }
    @Override public boolean isTransparent() { return props.isTransparent(); }
    @Override public void setTransparent(boolean transparent) { props.setTransparent(transparent); }

    @Override
    public void draw() {
        System.out.println("Drawing Circle..");
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
