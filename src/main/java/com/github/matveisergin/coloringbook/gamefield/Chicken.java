package com.github.matveisergin.coloringbook.gamefield;

import com.github.matveisergin.coloringbook.startpage.Illustrations;

import java.util.ArrayList;
import java.util.Arrays;

public class Chicken extends Illustration {
    private static final int WIDTH = 15;

    public Chicken() {
        super(String.valueOf(Illustrations.Chicken),
                new ArrayList<>(Arrays.asList(
                        AllColours.WHITE,
                        AllColours.YELLOW,
                        AllColours.RED,
                        AllColours.BLACK,
                        AllColours.BROWN
                )), WIDTH);
    }
}
