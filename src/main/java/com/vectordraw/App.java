package com.vectordraw;
    
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        Canvas canvas = new Canvas();

        // 1) Generate test data into the canvas' shape list
        createTestData(canvas.getShapes());

        // 2) Draw all shapes
        System.out.println("== Drawing all shapes ==");
        canvas.drawAll();

        // 3) Loop through canvas and print subtype + area for each shape
        System.out.println("\n== Shape types and areas ==");
        int totalArea = 0;
        for (Shape s : canvas.getShapes()) {
            String type = s.getClass().getSimpleName();
            double area = s.area();
            System.out.println(type + " area: " + area);
            totalArea += area;
        }
        System.out.println("Total area from Main(): " + totalArea);
        System.out.println("Total area from Canvas: " + canvas.totalArea());

        // 4) Loop through canvas and print lengt of line if shape is Line
        System.out.println("\n== Line lengths ==");
        for (Shape s : canvas.getShapes()) {
            if (s instanceof CanCalculateLength hasLength) {
                System.out.println("Line length: " + hasLength.calculateLength());
            }
        }
    }

    /**
     * Populates the provided List<Shape> with some test data.
     * This keeps test data creation separate from main logic.
     */
    public static void createTestData(ArrayList<Shape> shapes) {
        // Triangle
        Triangle t = new Triangle(3.0, 4.0, "red", false);
        shapes.add(t);

        // Rectangle
        Rectangle r = new Rectangle(2.0, 5.0, "blue", false);
        shapes.add(r);

        // Circle
        Circle c = new Circle(1.5, "green", true);
        shapes.add(c);

        // Lines
        Line l1 = new Line(new java.awt.Point(0, 0), new java.awt.Point(10, 10), "black", false);
        shapes.add(l1);

        Line l2 = new Line(new java.awt.Point(5, 0), new java.awt.Point(5, 20), "purple", false);
        shapes.add(l2);

        Line l3 = new Line(new java.awt.Point(-3, 4), new java.awt.Point(9, 4), "orange", false);
        shapes.add(l3);

        Line l4 = new Line(new java.awt.Point(0, 0), new java.awt.Point(3, 4), "gray", true);
        shapes.add(l4);
    }
}