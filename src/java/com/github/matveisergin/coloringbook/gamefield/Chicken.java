package com.github.matveisergin.coloringbook.gamefield;

import java.util.ArrayList;
import java.util.Arrays;

public class Chicken extends Illustration {
    public Chicken() {
        super("Chicken",
                new ArrayList<>(Arrays.asList(
                        AllColours.WHITE,
                        AllColours.YELLOW,
                        AllColours.RED,
                        AllColours.BLACK,
                        AllColours.BROWN
                )), 15);
    }
}
