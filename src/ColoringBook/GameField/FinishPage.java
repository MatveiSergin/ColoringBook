package ColoringBook.GameField;

import ColoringBook.GameField.ActionsForButtons.ActionForNoSave;
import ColoringBook.StartPage.ActionsForButtons.ActionExit;

import javax.swing.*;
import java.awt.*;

public class FinishPage extends JFrame {
    public FinishPage(JFrame frameWithPicture) {
        super("WIN");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.white);

        JPanel panel = new JPanel(new FlowLayout());
        JLabel text = new JLabel("      You are winner!!!!!");
        text.setFont(new Font("Verdana", Font.ITALIC, 20));
        text.setForeground(Color.red);
        JButton exitGame = new JButton("Exit");
        exitGame.addActionListener(new ActionExit());
        JButton menu = new JButton("Menu");
        menu.addActionListener(new ActionForNoSave(this, frameWithPicture));
        panel.add(menu);
        panel.add(exitGame);
        add(text, BorderLayout.NORTH);
        add(panel, BorderLayout.SOUTH);
    }
}
