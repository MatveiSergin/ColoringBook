package StartPage;

import Database.RequestToDatabase;
import StartPage.ActionsForButtons.ActionBackToStartPage;
import StartPage.ActionsForButtons.ActionForNewIllustration;
import StartPage.ActionsForButtons.ActionForOldIllustration;

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
        setBackground(Color.white);
        setLocationRelativeTo(null);
        FillChoosingIllustrations();
    }

    public void outputFrame() {
        setVisible(true);
    }

    private void FillChoosingIllustrations() throws IOException {
        JLabel name = addNameOnChoosingIllustration();
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.white);
        Illustrations[] possibleValues = Illustrations.values();
        for (Illustrations illustration: possibleValues) {
            JPanel menuComponent = new JPanel(new GridLayout(1, 1));

            JLabel pictures = addPictureOnChoosingIllustration(illustration);
            JButton button = addButtonOnChoosingIllustration(illustration);

            menuComponent.add(pictures);
            menuComponent.add(button);

            panel.add(button);
            panel.add(pictures);
        }

        JButton button = addButtonFromDatabase();
        panel.add(button);
        JButton undo = addUndoOnChoosingIllustration();

        add(undo, BorderLayout.SOUTH);
        add(name, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    private JLabel addNameOnChoosingIllustration() {
        JLabel name = new JLabel("Choose illustration");
        name.setFont(new Font("Verdana", Font.ITALIC, 20));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setForeground(Color.red);
        name.setOpaque(true);
        name.setBackground(Color.white);
        name.setPreferredSize(new Dimension(350, 100));
        return name;
    }
    private JLabel addPictureOnChoosingIllustration(Illustrations illustration) throws IOException {
        JLabel pictures = new JLabel(new ImageIcon(ImageIO.read(new File("src\\ColoringBook\\media\\" + illustration.name() + ".jpg"))));
        pictures.setOpaque(true);
        pictures.setBackground(Color.WHITE);
        return pictures;
    }
    private JButton addButtonOnChoosingIllustration(Illustrations illustration) {
        JButton button = new JButton("<html><h2><font color=\"blue\">" + illustration.name());
        button.setBorderPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(new ActionForNewIllustration(illustration.name(), this));
        button.setPreferredSize(new Dimension(350, 50));
        return button;
    }

    private JButton addButtonFromDatabase() {
        RequestToDatabase requestToDatabase = new RequestToDatabase();
        String[] lastPictures = requestToDatabase.getLastPictures();

        JButton button = new JButton("<html><h2><font color=\"blue\">" + "Finish the last drawing");
        button.setBorderPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setPreferredSize(new Dimension(350, 50));

        if (lastPictures == null) {
            return button;
        }

        button.addActionListener(new ActionForOldIllustration(lastPictures[1], lastPictures[2],  this));
        return button;
    }

    private JButton addUndoOnChoosingIllustration() {
        JButton undo = new JButton("<html><h2><font color=\"black\">Back");
        undo.addActionListener(new ActionBackToStartPage(this));
        undo.setBorderPainted(false);
        undo.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        undo.setFocusPainted(false);
        undo.setContentAreaFilled(false);
        undo.setOpaque(true);
        undo.setBackground(Color.white);
        return undo;
    }
}
