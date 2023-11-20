package GameField.ActionsForButtons;

import Database.RequestToDatabase;
import GameField.Action;
import StartPage.StartPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionForSave implements ActionListener {
    private Action action;
    private JFrame frameWithWindowForSave;
    private JFrame frameWithPictures;

    public ActionForSave(JFrame frameWithWindowForSave, JFrame frameWithPictures,  Action action) {
        this.action = action;
        this.frameWithWindowForSave = frameWithWindowForSave;
        this.frameWithPictures = frameWithPictures;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RequestToDatabase requestToDatabase = new RequestToDatabase();
        requestToDatabase.savePictures(action.getNameOfIllustration(), action.getPositionOfColors());
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
