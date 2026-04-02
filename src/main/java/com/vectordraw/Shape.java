package com.vectordraw;

public interface Shape extends Drawable {
    String getColor();
    void setColor(String color);
    boolean isTransparent();
    void setTransparent(boolean transparent);
}
