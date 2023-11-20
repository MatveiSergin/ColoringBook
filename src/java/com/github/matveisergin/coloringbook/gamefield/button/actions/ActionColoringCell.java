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
                progressLabel.setText("Progress: " + action.getProgress() + "%");
                cell.setColour(colour);
                if (action.getProgress().equals("100,0")) {
                    FinishPage finishPage = new FinishPage(frameWithPictures);
                }
            }
        }
    }
}
