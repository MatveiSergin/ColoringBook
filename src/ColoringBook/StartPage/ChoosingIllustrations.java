package ColoringBook.StartPage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ChoosingIllustrations extends JFrame {
    public ChoosingIllustrations() throws HeadlessException, IOException {
        super("Choosing illustration");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 700);

        JLabel name = new JLabel("Choose illustration");
        name.setFont(new Font("Verdana", Font.ITALIC, 20));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setForeground(Color.red);
        name.setOpaque(true);
        name.setBackground(Color.white);
        name.setPreferredSize(new Dimension(350, 100));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.white);
        Illustrations[] possibleValues = Illustrations.values();

        for (Illustrations illustration:
                possibleValues) {
            JPanel menuComponent = new JPanel(new GridLayout(2, 1));
            JLabel pictures = new JLabel(new ImageIcon(ImageIO.read(new File("src\\ColoringBook\\media\\" + illustration.name() + ".jpg"))));
            pictures.setOpaque(true);
            pictures.setBackground(Color.WHITE);

            JButton button = new JButton("<html><h2><font color=\"blue\">" + illustration.name());
            button.setBorderPainted(false);
            button.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.addActionListener(new ActionForIllustration(illustration.name(), this));
            button.setPreferredSize(new Dimension(350, 50));
            menuComponent.add(pictures);
            menuComponent.add(button);
            panel.add(button);
            panel.add(pictures);
        }

        JButton undo = new JButton("<html><h2><font color=\"black\">Back");
        undo.addActionListener(new ActionBackToStartPage(this));
        undo.setBorderPainted(false);
        undo.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        undo.setFocusPainted(false);
        undo.setContentAreaFilled(false);
        undo.setOpaque(true);
        undo.setBackground(Color.white);

        add(undo, BorderLayout.SOUTH);
        add(name, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setBackground(Color.white);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
