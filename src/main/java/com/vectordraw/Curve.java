package com.vectordraw;

public class Curve implements Drawable, CanCalculateLength {

    private ShapeProperties props;
    private float radius;
    private int angle;

    public Curve(float radius, int angle, String color, boolean transparent) {
        this.props = new ShapeProperties(color, transparent);
        this.radius = radius;
        this.angle = angle;
    }

    public float getRadius() {
        return radius;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public double calculateLength() {
        return 2 * Math.PI * radius * (angle / 360.0);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Curve [" + props + "]");
    }
}
