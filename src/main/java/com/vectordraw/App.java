package com.vectordraw;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        // Canvas initialised with demo data via constructor
        Canvas canvas = new Canvas(createTestData());

        // 2) Draw all shapes
        System.out.println("== Drawing all shapes ==");
        canvas.drawAll();

        // 3) Total area via AreaCalculatorService
        AreaCalculatorService areaService = new AreaCalculatorService();
        System.out.println("\n== Total area ==");
        System.out.println("Total area: " + areaService.totalArea(canvas.getShapes()));

        // 4) Lengths via LengthCalculatorService
        LengthCalculatorService lengthService = new LengthCalculatorService();
        System.out.println("\n== Lengths (CanCalculateLength) ==");
        lengthService.printLengths(canvas.getShapes());
    }

    public static List<Drawable> createTestData() {
        List<Drawable> shapes = new ArrayList<>();
        shapes.add(new Triangle(3.0, 4.0, "red", false));
        shapes.add(new Rectangle(2.0, 5.0, "blue", false));
        shapes.add(new Circle(1.5, "green", true));
        shapes.add(new Line(new java.awt.Point(0, 0), new java.awt.Point(10, 10), "black", false));
        shapes.add(new Line(new java.awt.Point(5, 0), new java.awt.Point(5, 20), "purple", false));
        shapes.add(new Line(new java.awt.Point(-3, 4), new java.awt.Point(9, 4), "orange", false));
        shapes.add(new Line(new java.awt.Point(0, 0), new java.awt.Point(3, 4), "gray", true));
        shapes.add(new Curve(5.0f, 90, "teal", false));
        shapes.add(new Curve(10.0f, 180, "pink", true));
        return shapes;
    }
}