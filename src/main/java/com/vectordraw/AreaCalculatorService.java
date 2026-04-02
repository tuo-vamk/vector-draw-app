package com.vectordraw;

import java.util.List;

public class AreaCalculatorService {

    public double totalArea(List<Drawable> drawables) {
        double total = 0;
        for (Drawable d : drawables) {
            if (d instanceof CanCalculateArea) {
                total += ((CanCalculateArea) d).calculateArea();
            }
        }
        return total;
    }
}
