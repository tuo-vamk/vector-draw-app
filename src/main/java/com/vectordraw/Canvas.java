package com.vectordraw;

import java.util.ArrayList;

public class Canvas {

    private ArrayList<Drawable> shapes;

    public Canvas() {
        shapes = new ArrayList<>();
    }

    public ArrayList<Drawable> getShapes() {
        return shapes;
    }

    public void addShape(Drawable shape) {
        shapes.add(shape);
    }

    public void removeShape(Drawable shape) {
        shapes.remove(shape);
    }

    public void drawAll() {
        for (Drawable shape : shapes) {
            shape.draw();
        }
    }
}
