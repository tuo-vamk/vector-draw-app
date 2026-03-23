package com.vectordraw;

public class Shape {

    private String color;
    private boolean transparent;

    public Shape(String color, boolean transparent) {
        this.color = color;
        this.transparent = transparent;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isTransparent() {
        return transparent;
    }

    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }

    public void draw()
    {
        System.out.printf("Shape is abstract thing, so not able to draw it.");
    }

    public double area()
    {
        return -1;
    }
}
