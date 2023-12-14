package com.github.matveisergin.coloringbook.gamefield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class ColourTest {
    private Colour colour1;
    private Colour colour2;
    private Colour colour3;
    private static final String BLACK = "black";
    private static final String WHITE = "white";
    private static final String RED = "red";

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

    @Test
    void testSetSelected() {
        Assertions.assertFalse(colour1.isSelected());
        colour1.setSelected(true);
        Assertions.assertTrue(colour1.isSelected());

        colour2.setSelected(true);
        colour2.setSelected(false);
        Assertions.assertFalse(colour2.isSelected());
    }

    @Test void testGetName() {
        Assertions.assertEquals(colour1.getName(), BLACK);
        Assertions.assertEquals(colour2.getName(), WHITE);
        Assertions.assertEquals(colour3.getName(), RED);
    }
}
