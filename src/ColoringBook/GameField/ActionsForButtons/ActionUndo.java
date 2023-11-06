package ColoringBook.GameField.ActionsForButtons;

import ColoringBook.GameField.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionUndo implements ActionListener {
    private ColoringBook.GameField.Action action;
    private JLabel progressLabel;

    public ActionUndo(Action action, JLabel progressLabel) {
        this.action = action;
        this.progressLabel = progressLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        action.removeLastAction();
        progressLabel.setText("Progress: " + action.getProgress() + "%");
    }
}
