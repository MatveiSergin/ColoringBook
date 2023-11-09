package ColoringBook.GameField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColoringCell implements ActionListener {

    private Cell cell;
    private Palette palette;
    private Action action;
    private JLabel progressLabel;
    public ColoringCell(Cell cell, Palette palette, Action action, JLabel progressLabel) {
        this.cell = cell;
        this.palette = palette;
        this.action = action;
        this.progressLabel = progressLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Colour colour :
                palette.getColours()) {
            if (colour.isSelected()) {
                action.addAction(cell, cell.getColour(), colour);
                progressLabel.setText("Progress: " + action.getProgress() + "%");
                cell.setColour(colour);
            }
        }
    }
}
