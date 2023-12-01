package com.github.matveisergin.coloringbook.gamefield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaletteTest {

    private Palette palette;
    private int EXPECTED_SIZE = 2;

    @BeforeEach
    void createPalette() {
        palette = new Palette();
    }

    @Test
    void testGetColours() {
        Assertions.assertTrue(palette.getColours().isEmpty());

        Colour firstColour = new Colour(AllColours.BLACK, 1);
        palette.addColour(firstColour);
        Assertions.assertEquals(firstColour, palette.getColours().get(0));
    }

    @Test
    void testAddColour() {
        Colour firstColour = new Colour(AllColours.BLACK, 1);
        Colour secondColour = new Colour(AllColours.BLUE, 2);

        Assertions.assertTrue(palette.getColours().isEmpty());

        palette.addColour(firstColour);
        Colour testFirstColour = palette.getColours().get(0);
        Assertions.assertEquals(firstColour, testFirstColour);

        palette.addColour(secondColour);
        int paletteSize = palette.getColours().size();
        Assertions.assertEquals(EXPECTED_SIZE, paletteSize);
        Assertions.assertArrayEquals(new Colour[]{firstColour, secondColour}, palette.getColours().toArray());
    }
}
