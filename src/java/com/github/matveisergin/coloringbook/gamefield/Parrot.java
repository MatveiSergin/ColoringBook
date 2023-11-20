package com.github.matveisergin.coloringbook.gamefield;

import java.util.ArrayList;
import java.util.Arrays;

public class Parrot extends Illustration {

    public Parrot() {
        super("Parrot",
                new ArrayList<>(Arrays.asList(
                AllColours.WHITE,
                AllColours.YELLOW,
                AllColours.RED,
                AllColours.GREEN,
                AllColours.BLUE,
                AllColours.BLACK,
                AllColours.BROWN,
                AllColours.LIGHT_BLUE,
                AllColours.LIGHT_YELLOW)),
                15);
    }
}
