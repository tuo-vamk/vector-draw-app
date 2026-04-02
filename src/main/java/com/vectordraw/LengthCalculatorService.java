package com.vectordraw;

import java.util.List;

public class LengthCalculatorService {

    public void printLengths(List<Drawable> drawables) {
        for (Drawable d : drawables) {
            if (d instanceof CanCalculateLength) {
                System.out.println(d.getClass().getSimpleName() + " length: "
                        + ((CanCalculateLength) d).calculateLength());
            }
        }
    }
}
