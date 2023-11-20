package com.github.matveisergin.coloringbook.gamefield.button.actions;

import com.github.matveisergin.coloringbook.gamefield.Action;
import com.github.matveisergin.coloringbook.gamefield.WindowForSave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionExitToStartPage implements ActionListener {

    private JFrame frame;
    private Action action;

    public ActionExitToStartPage(JFrame frame, Action action) {
        this.frame = frame;
        this.action = action;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowForSave windowForSave = new WindowForSave(frame, action);
        windowForSave.outputFrame();
    }
}
