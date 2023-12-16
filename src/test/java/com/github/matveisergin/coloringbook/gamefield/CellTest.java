package com.github.matveisergin.coloringbook.gamefield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

public class CellTest {
    private Cell cell;
    private Illustration illustration = new Parrot();
    private Palette palette = new Palette();
    private static final int EXPECTED_INDEX = 7;
    private static final int EXPECTED_NUMBER = 3;
    private static final String EXPECTED_NAME_FOR_COLOUR = "white";
    private static final Color EXPECTED_COLOR = Color.red;

    @BeforeEach
    void createCell() {
        for (int i = 0; i < illustration.getColors().size(); i++) {
            palette.addColour(new Colour(illustration.getColors().get(i), i + 1));
        }
        cell = new Cell(1, 3, 7, palette);
    }

    @Test
    void testCellConstructor() {
        int testIndex = cell.getIndex();
        int testNumber = cell.getNumber();
        Colour testColour = cell.getColour();
        Assertions.assertEquals(EXPECTED_INDEX, testIndex);
        Assertions.assertEquals(EXPECTED_NUMBER, testNumber);
        Assertions.assertEquals(EXPECTED_NAME_FOR_COLOUR, testColour.getName());
    }

    @Test
    void testSetColourMethod() {
        Colour newColor = palette.getColours().get(2);
        cell.setColour(newColor);
        Color testColor = cell.getBackground();
        Assertions.assertEquals(EXPECTED_COLOR.getRGB(), testColor.getRGB());
    }
}
