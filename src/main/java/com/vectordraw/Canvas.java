package com.vectordraw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Canvas {

    private ArrayList<Drawable> shapes;

    public Canvas() {
        shapes = new ArrayList<>();
    }

    public Canvas(List<Drawable> initialShapes) {
        shapes = new ArrayList<>(initialShapes);
    }

    public void addShape(Drawable shape) {
        shapes.add(shape);
    }

    public List<Drawable> getShapes() {
        return Collections.unmodifiableList(shapes);
    }

    public void drawAll() {
        for (Drawable shape : shapes) {
            shape.draw();
        }
    }
}
