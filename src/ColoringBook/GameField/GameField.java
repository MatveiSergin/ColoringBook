package GameField;

import GameField.ActionsForButtons.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameField extends JFrame {
    private Illustration illustration;
    private int width;
    private Action action;
    private JLabel progressLabel = new JLabel("Progress: 0%");
    private JLabel selectedColorLabel = new JLabel("Selected color: ");
    public GameField(String illustration) throws IOException {
        super("Coloring by numbers");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(900, 750);
        setLocationRelativeTo(null);

        chooseIllustration(illustration);
        action = new Action(this.illustration);
        addWindowListener(new ClosingGameField(this, action));
        fillGameField();
        outputFrame();
    }

    public GameField(String illustration, String positionOfColors) throws IOException {
        super("Coloring by numbers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 750);
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
            case ("Parrot"):
                this.illustration = new Parrot();
                width = this.illustration.getWidth();
                break;
            case ("Chicken"):
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
        ArrayList<AllColours> colorsForIllustration= this.illustration.getColors();

        for (int i = 0; i < colorsForIllustration.size(); i++) {
            Colour colour = new Colour(colorsForIllustration.get(i), i + 1);
            colour.addActionListener(new ActionChoiceColour(colour, palette, selectedColorLabel, action));
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

        JButton undo = new JButton("Undo");
        undo.addActionListener(new ActionUndo(action, progressLabel));

        JButton exitToStartPage = new JButton("Exit to menu");
        exitToStartPage.addActionListener(new ActionExitToStartPage(this, action));

        JButton clearField = new JButton("All clear");
        clearField.addActionListener(new ActionClearField(action, progressLabel));

        actionsPanel.add(progressLabel, BorderLayout.WEST);
        actionsPanel.add(undo);
        actionsPanel.add(clearField);
        actionsPanel.add(exitToStartPage);
        actionsPanel.add(selectedColorLabel, BorderLayout.EAST);
        return actionsPanel;
    }
}
