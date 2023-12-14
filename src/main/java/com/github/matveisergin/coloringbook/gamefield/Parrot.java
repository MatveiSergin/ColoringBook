package com.github.matveisergin.coloringbook.gamefield;

import com.github.matveisergin.coloringbook.startpage.Illustrations;

import java.util.ArrayList;
import java.util.Arrays;

public class Parrot extends Illustration {
    private static final int WIDTH = 15;

    public Parrot() {
        super(String.valueOf(Illustrations.Parrot),
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
                WIDTH);
    }
}
