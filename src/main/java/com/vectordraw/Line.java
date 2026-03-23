package com.vectordraw;

import java.awt.Point;

public class Line extends Shape {
        private Point start;
        private Point end;

        public Line(Point start, Point end, String color, boolean transparent) {
            super(color, transparent);
            this.start = start;
            this.end = end;
        }

    @Override
    public void draw() {
        System.out.println("Drawing Line..");
    }

    @Override
    public double area() {
        return -1;
    }
}
