package GameField.ActionsForButtons;

import Database.RequestToDatabase;
import GameField.Action;
import GameField.WindowForSave;
import StartPage.StartPage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionExitToStartPage implements ActionListener {

    private JFrame frame;
    private Action action;

    public ActionExitToStartPage(JFrame frame, Action action) {
        this.frame = frame;
        this.action = action;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowForSave windowForSave = new WindowForSave(frame, action);
        windowForSave.outputFrame();
    }
}
