package com.github.matveisergin.coloringbook.gamefield;

import com.github.matveisergin.coloringbook.gamefield.button.actions.ActionForNoSave;
import com.github.matveisergin.coloringbook.gamefield.button.actions.ActionForSave;

import javax.swing.*;
import java.awt.*;

public class WindowForSave extends JFrame {
    private Action action;
    private JFrame frameWithPictures;
    private static final int[] WINDOW_RESOLUTION = new int[]{150, 150};
    private static final String SAVE_A_PICTURE = "Save a picture?";
    private static final String SAVE = "Save";
    private static final String DON_T_SAVE = "don`t save";
    private static final String SAVE_PICTURES = "Save pictures";

    public WindowForSave(JFrame frameWithPictures, Action action) {
        super(SAVE_PICTURES);
        this.action = action;
        this.frameWithPictures = frameWithPictures;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_RESOLUTION[0], WINDOW_RESOLUTION[1]);
        setLocationRelativeTo(null);
        fillWindowForSave();
    }

    public void outputFrame() {
        setVisible(true);
    }

    private void fillWindowForSave() {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel information = new JLabel(SAVE_A_PICTURE);
        JButton buttonForSave = new JButton(SAVE);
        buttonForSave.addActionListener(new ActionForSave(this, frameWithPictures, action));
        JButton buttonForNoSave = new JButton(DON_T_SAVE);
        buttonForNoSave.addActionListener(new ActionForNoSave(this, frameWithPictures));
        panel.add(information);
        panel.add(buttonForSave);
        panel.add(buttonForNoSave);
        add(panel);
    }
}
