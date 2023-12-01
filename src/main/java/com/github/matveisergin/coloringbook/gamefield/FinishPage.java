package com.github.matveisergin.coloringbook.gamefield;

import com.github.matveisergin.coloringbook.gamefield.button.actions.ActionForNoSave;
import com.github.matveisergin.coloringbook.startpage.button.actions.ActionExit;

import javax.swing.*;
import java.awt.*;

public class FinishPage extends JFrame {
    private static final int[] WINDOW_RESOLUTION = new int[]{300, 150};
    private static final String EXIT = "Exit";
    private static final String MENU = "Menu";
    private static final String WIN = "WIN";
    private static final int FONT_SIZE = 20;
    private static final String FONT_NAME = "Verdana";
    private static final String TEXT = "      You are winner!!!!!";

    public FinishPage(JFrame frameWithPicture) {
        super(WIN);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(WINDOW_RESOLUTION[0], WINDOW_RESOLUTION[1]);
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
        JLabel text = new JLabel(TEXT);

        text.setFont(new Font(FONT_NAME, Font.ITALIC, FONT_SIZE));
        text.setForeground(Color.red);

        JButton exitGame = new JButton(EXIT);
        exitGame.addActionListener(new ActionExit());

        JButton menu = new JButton(MENU);
        menu.addActionListener(new ActionForNoSave(this, frameWithPicture));

        panel.add(menu);
        panel.add(exitGame);

        add(text, BorderLayout.NORTH);
        add(panel, BorderLayout.SOUTH);
    }
}
