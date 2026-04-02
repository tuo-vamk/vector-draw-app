package com.vectordraw;

public class Rectangle implements Shape, CanCalculateArea {

    private ShapeProperties props;
    private double width;
    private double height;

    public Rectangle(double width, double height, String color, boolean transparent) {
        this.props = new ShapeProperties(color, transparent);
        this.width = width;
        this.height = height;
    }

    @Override public String getColor() { return props.getColor(); }
    @Override public void setColor(String color) { props.setColor(color); }
    @Override public boolean isTransparent() { return props.isTransparent(); }
    @Override public void setTransparent(boolean transparent) { props.setTransparent(transparent); }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle..");
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
