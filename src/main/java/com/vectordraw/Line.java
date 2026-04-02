package com.vectordraw;

import java.awt.Point;

public class Line implements Drawable, CanCalculateLength {

    private ShapeProperties props;
    private Point start;
    private Point end;

    public Line(Point start, Point end, String color, boolean transparent) {
        this.props = new ShapeProperties(color, transparent);
        this.start = start;
        this.end = end;
    }

    @Override
    public double calculateLength() {
        int dx = end.x - start.x;
        int dy = end.y - start.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Line [" + props + "]");
    }
}
