package com.github.matveisergin.coloringbook.startpage.button.actions;

import com.github.matveisergin.coloringbook.gamefield.GameField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionForOldIllustration implements ActionListener {
    private String name;
    private String positionOfColors;
    private JFrame frame;
    public ActionForOldIllustration(String name, String positionOfColors, JFrame frame) {
        this.name = name;
        this.positionOfColors = positionOfColors;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            frame.dispose();
            GameField gameField = new GameField(name, positionOfColors);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
