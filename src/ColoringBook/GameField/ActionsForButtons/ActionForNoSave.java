package GameField.ActionsForButtons;

import Database.RequestToDatabase;
import StartPage.StartPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionForNoSave implements ActionListener {
    private JFrame frameWithWindowForSave;
    private JFrame frameWithPictures;


    public ActionForNoSave(JFrame frameWithSpecialWindow, JFrame frameWithPictures) {
        this.frameWithWindowForSave = frameWithSpecialWindow;
        this.frameWithPictures = frameWithPictures;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameWithWindowForSave.dispose();
        frameWithPictures.dispose();
        try {
            StartPage startPage = new StartPage();
            startPage.outputFrame();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
