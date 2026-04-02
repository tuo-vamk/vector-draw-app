package com.vectordraw;

public class ShapeProperties {

    private String color;
    private boolean transparent;

    public ShapeProperties(String color, boolean transparent) {
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

    @Override
    public String toString() {
        return "color=" + color + ", transparent=" + transparent;
    }
}
