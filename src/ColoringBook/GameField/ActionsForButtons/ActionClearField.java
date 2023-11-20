package GameField.ActionsForButtons;

import GameField.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionClearField implements ActionListener {
    private Action action;
    private JLabel progressLabel;
    public ActionClearField(Action action, JLabel progressLabel) {
        this.action = action;
        this.progressLabel = progressLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        action.removeAllAction();
        progressLabel.setText("Progress: " + action.getProgress() + "%");
    }
}
