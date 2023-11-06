package ColoringBook.GameField.ActionsForButtons;

import ColoringBook.GameField.Action;
import ColoringBook.GameField.Colour;
import ColoringBook.GameField.Palette;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionChoiceColour implements ActionListener {

    private Colour colour;
    private Palette palette;
    private JLabel infoLabel;
    private ColoringBook.GameField.Action action;
    public ActionChoiceColour(Colour colour, Palette palette, JLabel infoLabel, Action action) {
        this.colour = colour;
        this.palette = palette;
        this.infoLabel = infoLabel;
        this.action = action;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Colour colour : palette.getColours()) {
             colour.setSelected(false);
        }
        colour.setSelected(true);

        String info = "Selected color: " + colour.getName();
        infoLabel.setText(info);
    }
}
