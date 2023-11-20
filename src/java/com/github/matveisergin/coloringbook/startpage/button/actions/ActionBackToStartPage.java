package com.github.matveisergin.coloringbook.startpage.button.actions;

import com.github.matveisergin.coloringbook.startpage.Startpage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionBackToStartPage implements ActionListener {
    private JFrame frame;
    public ActionBackToStartPage(JFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        try {
            Startpage startPage = new Startpage();
            startPage.outputFrame();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
