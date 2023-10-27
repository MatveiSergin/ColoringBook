package ColoringBook.GameField;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GameField extends JFrame {

    public GameField(String selectedIllustration) throws IOException {
        super("Coloring by numbers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 750);

        Illustration illustration = null;
        int width = 0;

        if (selectedIllustration.equals("Parrot")) {
            illustration = new Parrot();
            width = illustration.getWidth();
        }
        else if (selectedIllustration.equals("Chicken")) {
            illustration = new Chicken();
            width = illustration.getWidth();
        }

        JLabel progressLabel = new JLabel("Progress: 0%");
        Action action = new Action(illustration);
        JSplitPane panel = new JSplitPane();
        JPanel fieldPanel = new JPanel(new GridLayout(width, width));
        JPanel actionsPanel = new JPanel(new FlowLayout());

        JButton undo = new JButton("Undo");
        undo.addActionListener(new ActionUndo(action, progressLabel));

        JButton exitToStartPage = new JButton("Exit to menu");
        exitToStartPage.addActionListener(new ActionExitToStartPage(this));

        JButton clearField = new JButton("All clear");
        clearField.addActionListener(new ActionClearField(action, progressLabel));

        JLabel selectedColorLabel = new JLabel("Selected color: ");
        actionsPanel.add(progressLabel, BorderLayout.WEST);
        actionsPanel.add(undo);
        actionsPanel.add(clearField);
        actionsPanel.add(exitToStartPage);
        actionsPanel.add(selectedColorLabel, BorderLayout.EAST);

        Palette palette = new Palette();
        ArrayList<AllColours> colorsForIllustration= illustration.getColors();

        for (int i = 0; i < colorsForIllustration.size(); i++) {
            Colour colour = new Colour(colorsForIllustration.get(i), i + 1);
            colour.addActionListener(new ActionChoiceColour(colour, palette, selectedColorLabel, action));
            palette.addColour(colour);
        }

        String numbers = illustration.getPositionOfColors();
        for (int i = 0; i < illustration.getWidth() * illustration.getWidth(); i++) {
            Cell cell = new Cell(Integer.parseInt(String.valueOf(numbers.charAt(i))), i, palette);
            cell.addActionListener(new ColoringCell(cell, palette, action, progressLabel));
            fieldPanel.add(cell);
        }

        add(actionsPanel, BorderLayout.NORTH);
        panel.setRightComponent(palette);
        panel.setLeftComponent(fieldPanel);
        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
