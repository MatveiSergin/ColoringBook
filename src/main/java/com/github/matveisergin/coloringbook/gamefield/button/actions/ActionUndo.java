package com.github.matveisergin.coloringbook.gamefield.button.actions;

import com.github.matveisergin.coloringbook.gamefield.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionUndo implements ActionListener {
    private Action action;
    private JLabel progressLabel;
    private final String PROGRESS = "Progress: %s%";

    public ActionUndo(Action action, JLabel progressLabel) {
        this.action = action;
        this.progressLabel = progressLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        action.removeLastAction();
        progressLabel.setText(String.format(PROGRESS, action.getProgress()));
    }
}
