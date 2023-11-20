package com.github.matveisergin.coloringbook.gamefield.button.actions;

import com.github.matveisergin.coloringbook.gamefield.Action;
import com.github.matveisergin.coloringbook.gamefield.WindowForSave;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClosingGameField extends WindowAdapter {
    private Action action;
    private JFrame frameWithPictures;
    public ClosingGameField(JFrame frameWithPictures, Action action) {
        this.frameWithPictures = frameWithPictures;
        this.action = action;
    }
    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        JFrame frame = (JFrame)e.getSource();
        WindowForSave windowForSave = new WindowForSave(frameWithPictures, action);
        windowForSave.outputFrame();

    }
}
