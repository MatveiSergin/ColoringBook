package GameField;

import GameField.ActionsForButtons.ActionForNoSave;
import GameField.ActionsForButtons.ActionForSave;

import javax.swing.*;
import java.awt.*;

public class WindowForSave extends JFrame {
    private Action action;
    private JFrame frameWithPictures;
    public WindowForSave(JFrame frameWithPictures, Action action) {
        super("Save pictures");
        this.action = action;
        this.frameWithPictures = frameWithPictures;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(150, 150);
        setLocationRelativeTo(null);
        fillWindowForSave();
    }

    public void outputFrame() {
        setVisible(true);
    }

    public void fillWindowForSave() {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel information = new JLabel("Save a picture?");
        JButton buttonForSave = new JButton("Save");
        buttonForSave.addActionListener(new ActionForSave(this, frameWithPictures, action));
        JButton buttonForNoSave = new JButton("don`t save");
        buttonForNoSave.addActionListener(new ActionForNoSave(this, frameWithPictures));
        panel.add(information);
        panel.add(buttonForSave);
        panel.add(buttonForNoSave);
        add(panel);
    }
}
