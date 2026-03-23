package com.vectordraw;

import java.util.ArrayList;

public class Canvas {

    private ArrayList<Shape> shapes;

    public Canvas() {
        shapes = new ArrayList<>();
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public void drawAll() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public double totalArea() {
        double total = 0;
        for (Shape shape : shapes) {
            if(shape.area() > 0) {
                total += shape.area();
            }
        }
        return total;
    }
}
