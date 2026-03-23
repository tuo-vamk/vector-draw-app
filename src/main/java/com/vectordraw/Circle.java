package com.vectordraw;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius, String color, boolean transparent) {
        super(color, transparent);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle..");
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
