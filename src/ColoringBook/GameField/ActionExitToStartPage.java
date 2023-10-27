package ColoringBook.GameField;

import ColoringBook.StartPage.StartPage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionExitToStartPage implements ActionListener {

    private JFrame frame;
    public ActionExitToStartPage(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        try {
            StartPage startPage = new StartPage();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
