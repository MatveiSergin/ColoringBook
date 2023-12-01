package com.github.matveisergin.coloringbook.gamefield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class ColourTest {
    private Colour colour1;
    private Colour colour2;
    private Colour colour3;

    @BeforeEach
    void createColour() {
        colour1 = new Colour(AllColours.BLACK, 1);
        colour2 = new Colour(AllColours.WHITE, 2);
        colour3 = new Colour(AllColours.RED, 3);
    }

    @Test
    void testGetColor() {
        Color testColor1 = colour1.getColor();
        Assertions.assertEquals(Color.BLACK, testColor1);

        Color testColor2 = colour2.getColor();
        Assertions.assertEquals(Color.WHITE, testColor2);

        Color testColor3 = colour3.getColor();
        Assertions.assertEquals(Color.RED, testColor3);
    }
}
