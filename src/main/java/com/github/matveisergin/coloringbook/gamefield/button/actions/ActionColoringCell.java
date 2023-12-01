package com.github.matveisergin.coloringbook.gamefield.button.actions;

import com.github.matveisergin.coloringbook.gamefield.*;
import com.github.matveisergin.coloringbook.gamefield.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionColoringCell implements ActionListener {

    private Cell cell;
    private Palette palette;
    private Action action;
    private JLabel progressLabel;
    private JFrame frameWithPictures;
    private static final String PROGRESS = "Progress: ";
    private static final String WINNER_PROGRESS = "100,0";
    private static final String SYMBOL_PROCENT = "%";

    public ActionColoringCell(Cell cell, Palette palette, Action action, JLabel progressLabel, JFrame frameWithPictures) {
        this.cell = cell;
        this.palette = palette;
        this.action = action;
        this.progressLabel = progressLabel;
        this.frameWithPictures = frameWithPictures;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Colour colour :
                palette.getColours()) {
            if (colour.isSelected()) {
                action.addAction(cell, cell.getColour(), colour);
                progressLabel.setText(PROGRESS + action.getProgress() + SYMBOL_PROCENT);
                cell.setColour(colour);
                if (action.getProgress().equals(WINNER_PROGRESS)) {
                    FinishPage finishPage = new FinishPage(frameWithPictures);
                    finishPage.outputFrame();
                }
            }
        }
    }
}
