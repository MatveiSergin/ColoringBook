package ColoringBook.StartPage;

import ColoringBook.GameField.GameField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionForIllustration implements ActionListener {
    private String name;
    private JFrame frame;
    public ActionForIllustration(String name, JFrame frame) {
        this.name = name;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            frame.dispose();
            GameField gameField = new GameField(name);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
