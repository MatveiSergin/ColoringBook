package com.github.matveisergin.coloringbook.gamefield.button.actions;

import com.github.matveisergin.coloringbook.gamefield.Action;
import com.github.matveisergin.coloringbook.gamefield.Colour;
import com.github.matveisergin.coloringbook.gamefield.Palette;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionChoiceColour implements ActionListener {

    private Colour colour;
    private Palette palette;
    private JLabel infoLabel;
    private final String SELECTED_COLOR = "Selected color: ";

    public ActionChoiceColour(Colour colour, Palette palette, JLabel infoLabel) {
        this.colour = colour;
        this.palette = palette;
        this.infoLabel = infoLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Colour colour : palette.getColours()) {
            colour.setSelected(false);
        }
        colour.setSelected(true);

        String info = SELECTED_COLOR + colour.getName();
        infoLabel.setText(info);
    }
}
