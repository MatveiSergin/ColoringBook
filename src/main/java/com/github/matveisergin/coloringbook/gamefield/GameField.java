package com.github.matveisergin.coloringbook.gamefield;

import com.github.matveisergin.coloringbook.gamefield.button.actions.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameField extends JFrame {
    private static final String COLORING_BY_NUMBERS = "Coloring by numbers";
    private final String PARROT = "Parrot";
    private final String CHICKEN = "Chicken";
    private Illustration illustration;
    private int width;
    private Action action;
    private final String START_PROGRESS_VALUE = "Progress: 0%";
    private final String START_SELECTED_COLOR = "Selected color: ";
    private final String UNDO = "Undo";
    private final String EXIT_TO_MENU = "Exit to menu";
    private final String ALL_CLEAR = "All clear";
    private JLabel progressLabel = new JLabel(START_PROGRESS_VALUE);
    private JLabel selectedColorLabel = new JLabel(START_SELECTED_COLOR);
    private final int[] WINDOW_RESOLUTION = new int[]{900, 750};

    public GameField(String illustration) throws IOException {
        super(COLORING_BY_NUMBERS);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(WINDOW_RESOLUTION[0], WINDOW_RESOLUTION[1]);
        setLocationRelativeTo(null);

        chooseIllustration(illustration);
        action = new Action(this.illustration);
        addWindowListener(new ClosingGameField(this, action));
        fillGameField();
        outputFrame();
    }

    public GameField(String illustration, String positionOfColors) throws IOException {
        super(COLORING_BY_NUMBERS);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_RESOLUTION[0], WINDOW_RESOLUTION[1]);
        setLocationRelativeTo(null);

        chooseIllustration(illustration);
        action = new Action(this.illustration, positionOfColors);
        addWindowListener(new ClosingGameField(this, action));
        fillGameField();
        outputFrame();
    }

    public void outputFrame() {
        setVisible(true);
    }

    private void chooseIllustration(String illustration) {
        switch (illustration) {
            case PARROT:
                this.illustration = new Parrot();
                width = this.illustration.getWidth();
                break;
            case CHICKEN:
                this.illustration = new Chicken();
                width = this.illustration.getWidth();
                break;
        }
    }

    private void fillGameField() {
        Palette palette = addPaletteOnGameField();
        JPanel fieldPanel = addCellsOnGameField(palette);
        JPanel actionsPanel = addActionsPanelOnGameField();

        JSplitPane panel = new JSplitPane();
        add(actionsPanel, BorderLayout.NORTH);
        panel.setRightComponent(palette);
        panel.setLeftComponent(fieldPanel);
        add(panel);
    }

    private Palette addPaletteOnGameField() {
        Palette palette = new Palette();
        ArrayList<AllColours> colorsForIllustration = this.illustration.getColors();

        for (int i = 0; i < colorsForIllustration.size(); i++) {
            Colour colour = new Colour(colorsForIllustration.get(i), i + 1);
            colour.addActionListener(new ActionChoiceColour(colour, palette, selectedColorLabel));
            palette.addColour(colour);
        }
        return palette;
    }

    private JPanel addCellsOnGameField(Palette palette) {
        JPanel fieldPanel = new JPanel(new GridLayout(width, width));
        String numbers = this.illustration.getPositionOfColors();
        List<Integer> currentResult = action.getCurrentResult();

        for (int i = 0; i < this.illustration.getWidth() * this.illustration.getWidth(); i++) {
            Cell cell = new Cell(currentResult.get(i), Character.getNumericValue(numbers.charAt(i)), i, palette);
            cell.addActionListener(new ActionColoringCell(cell, palette, action, progressLabel, this));
            fieldPanel.add(cell);
        }
        return fieldPanel;
    }

    private JPanel addActionsPanelOnGameField() {
        JPanel actionsPanel = new JPanel(new FlowLayout());

        JButton undo = new JButton(UNDO);
        undo.addActionListener(new ActionUndo(action, progressLabel));

        JButton exitToStartPage = new JButton(EXIT_TO_MENU);
        exitToStartPage.addActionListener(new ActionExitToStartPage(this, action));

        JButton clearField = new JButton(ALL_CLEAR);
        clearField.addActionListener(new ActionClearField(action, progressLabel));

        actionsPanel.add(progressLabel, BorderLayout.WEST);
        actionsPanel.add(undo);
        actionsPanel.add(clearField);
        actionsPanel.add(exitToStartPage);
        actionsPanel.add(selectedColorLabel, BorderLayout.EAST);
        return actionsPanel;
    }
}
