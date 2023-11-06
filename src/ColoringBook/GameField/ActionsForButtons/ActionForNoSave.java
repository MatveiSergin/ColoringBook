package ColoringBook.GameField.ActionsForButtons;

import ColoringBook.Database.RequestToDatabase;
import ColoringBook.StartPage.StartPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionForNoSave implements ActionListener {
    private JFrame frameWithWindowForSave;
    private JFrame frameWithPictures;


    public ActionForNoSave(JFrame frameWithWindowForSave, JFrame frameWithPictures) {
        this.frameWithWindowForSave = frameWithWindowForSave;
        this.frameWithPictures = frameWithPictures;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameWithWindowForSave.dispose();
        frameWithPictures.dispose();
        try {
            StartPage startPage = new StartPage();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
