package ColoringBook.StartPage.ActionsForButtons;

import ColoringBook.StartPage.ChoosingIllustrations;

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
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
