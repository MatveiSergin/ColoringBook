package StartPage.ActionsForButtons;

import GameField.GameField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionForNewIllustration implements ActionListener {
    private String name;
    private JFrame frame;
    public ActionForNewIllustration(String name, JFrame frame) {
        this.name = name;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            frame.dispose();
            GameField gameField = new GameField(name);
            gameField.outputFrame();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
