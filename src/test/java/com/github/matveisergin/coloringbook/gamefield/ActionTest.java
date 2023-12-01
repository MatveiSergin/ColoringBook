package com.github.matveisergin.coloringbook.gamefield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ActionTest {
    private Action testAction;
    private Illustration illustration = new Parrot();
    private static final String EXPECTED_PROGRESS_DURING_INIT = "0,0";
    private static final int EXPECTED_QUANTITY_ONES = 225;
    private static final int EXPECTED_SIZE = 1;
    private static final String EXPECTED_PROGRESS = "1,3";

    @BeforeEach
    void initAction() {

        testAction = new Action(illustration);
    }

    @Test
    void testActionConstructor() {
        String initProgress = testAction.getProgress();
        Assertions.assertEquals(EXPECTED_PROGRESS_DURING_INIT, initProgress);

        List<Integer> testingCurrentResult = testAction.getCurrentResult();
        int counterOfOnes = 0;
        for (int element : testingCurrentResult) {
            if (element == 1) {
                counterOfOnes += 1;
            }
        }
        Assertions.assertEquals(EXPECTED_QUANTITY_ONES, counterOfOnes);
    }

    @Test
    void testAddActionMethod() {
        Palette palette = new Palette();
        palette.addColour(new Colour(AllColours.BLUE, 1));
        Cell simpleCell = new Cell(1, 0, 0, palette);
        Colour lastColour = new Colour(AllColours.BLUE, 1);
        Colour newColour = new Colour(AllColours.BLACK, 0);

        testAction.addAction(simpleCell, lastColour, newColour);
        List<Map.Entry<Cell, Colour[]>> testPairList = testAction.getPairList();
        Assertions.assertEquals(EXPECTED_SIZE, testPairList.size());

        String currentProgress = testAction.getProgress();
        Assertions.assertEquals(EXPECTED_PROGRESS_DURING_INIT, currentProgress);
    }

    @Test
    void testRemoveAllActionMethod() {
        Palette palette = new Palette();
        palette.addColour(new Colour(AllColours.BLUE, 1));
        Cell simpleCell = new Cell(1, 0, 0, palette);
        Colour lastColour = new Colour(AllColours.BLUE, 1);
        Colour newColour = new Colour(AllColours.BLACK, 0);

        testAction.addAction(simpleCell, lastColour, newColour);
        testAction.addAction(simpleCell, newColour, lastColour);
        testAction.removeAllAction();

        Assertions.assertEquals(0, testAction.getPairList().size());
    }

    @Test
    void testRemoveLastActionMethod() {
        Palette palette = new Palette();
        palette.addColour(new Colour(AllColours.BLUE, 1));
        Cell simpleCell = new Cell(1, 0, 0, palette);
        Colour lastColour = new Colour(AllColours.BLUE, 1);
        Colour newColour = new Colour(AllColours.BLACK, 0);

        testAction.addAction(simpleCell, lastColour, newColour);
        testAction.addAction(simpleCell, newColour, lastColour);
        testAction.removeLastAction();

        Assertions.assertEquals(1, testAction.getPairList().size());
    }

    @Test
    void testCalculateProgress() {
        Palette palette = new Palette();
        for (int i = 0; i < illustration.getColors().size(); i++) {
            palette.addColour(new Colour(illustration.getColors().get(i), i + 1));
        }
        Cell cell = new Cell(1, 3, 7, palette);
        Colour lastColour = new Colour(AllColours.WHITE, 6);
        Colour newColour = new Colour(AllColours.RED, 3);
        testAction.addAction(cell, lastColour, newColour);
        String curPrgoress = testAction.calculateProgress();

        Assertions.assertEquals(EXPECTED_PROGRESS, curPrgoress);

    }
}
