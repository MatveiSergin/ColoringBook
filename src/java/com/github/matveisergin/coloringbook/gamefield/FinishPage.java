package com.github.matveisergin.coloringbook.gamefield;

import com.github.matveisergin.coloringbook.gamefield.button.actions.ActionForNoSave;
import com.github.matveisergin.coloringbook.startpage.button.actions.ActionExit;

import javax.swing.*;
import java.awt.*;

public class FinishPage extends JFrame {
    public FinishPage(JFrame frameWithPicture) {
        super("WIN");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setBackground(Color.white);

        fillFinishPage(frameWithPicture);
        outputFrame();
    }

    public void outputFrame() {
        setVisible(true);
    }

    private void fillFinishPage(JFrame frameWithPicture) {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel text = new JLabel("      You are winner!!!!!");

        text.setFont(new Font("Verdana", Font.ITALIC, 20));
        text.setForeground(Color.red);

        JButton exitGame = new JButton("Exit");
        exitGame.addActionListener(new ActionExit());

        JButton menu = new JButton("Menu");
        menu.addActionListener(new ActionForNoSave(this, frameWithPicture));

        panel.add(menu);
        panel.add(exitGame);

        add(text, BorderLayout.NORTH);
        add(panel, BorderLayout.SOUTH);
    }
}
