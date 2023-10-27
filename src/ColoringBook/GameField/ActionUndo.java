package ColoringBook.GameField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionUndo implements ActionListener {
    private Action action;
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
