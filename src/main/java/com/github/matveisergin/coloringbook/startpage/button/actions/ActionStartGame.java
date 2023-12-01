package com.github.matveisergin.coloringbook.startpage.button.actions;

import com.github.matveisergin.coloringbook.startpage.ChoosingIllustrations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionStartGame implements ActionListener {
    private JFrame frame;
    public ActionStartGame(JFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        try {
            ChoosingIllustrations choosingIllustrations = new ChoosingIllustrations();
            choosingIllustrations.outputFrame();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
