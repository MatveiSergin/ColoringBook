package com.github.matveisergin.coloringbook.startpage;

import com.github.matveisergin.coloringbook.database.RequestToDatabase;
import com.github.matveisergin.coloringbook.startpage.button.actions.ActionBackToStartPage;
import com.github.matveisergin.coloringbook.startpage.button.actions.ActionForNewIllustration;
import com.github.matveisergin.coloringbook.startpage.button.actions.ActionForOldIllustration;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ChoosingIllustrations extends JFrame {
    private final int WIDTH2 = 350;
    private final int HEIGHT2 = 50;
    private final String FONT_COLOR_BLUE = "<html><h2><font color=\"blue\">";
    private final String FINISH_THE_LAST_DRAWING = "Finish the last drawing";
    private final String BACK = "<html><h2><font color=\"black\">Back";
    private final int TWO = 2;
    private final String FILE_PATH = "C:\\workspace\\mai\\235\\23\\Kursach\\src\\main\\java\\com\\github\\matveisergin\\coloringbook\\media\\%s.jpg";
    private static final String CHOOSING_ILLUSTRATION = "Choosing illustration";
    private final String CHOOSE_ILLUSTRATION = "Choose illustration";
    private final int[] WINDOW_RESOLUTION = new int[]{350, 700};
    private final int FONT_SIZE = 20;
    private final String FONT_NAME = "Verdana";
    private final int WIDTH1 = 350;
    private final int HEIGHT1 = 100;

    public ChoosingIllustrations() throws HeadlessException, IOException {
        super(CHOOSING_ILLUSTRATION);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_RESOLUTION[0], WINDOW_RESOLUTION[1]);
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
        for (Illustrations illustration : possibleValues) {
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
        JLabel name = new JLabel(CHOOSE_ILLUSTRATION);
        name.setFont(new Font(FONT_NAME, Font.ITALIC, FONT_SIZE));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setForeground(Color.red);
        name.setOpaque(true);
        name.setBackground(Color.white);
        name.setPreferredSize(new Dimension(WIDTH1, HEIGHT1));
        return name;
    }

    private JLabel addPictureOnChoosingIllustration(Illustrations illustration) throws IOException {
        JLabel pictures = new JLabel(new ImageIcon(ImageIO.read(
                new File(String.format(FILE_PATH, illustration.name())))));
        pictures.setOpaque(true);
        pictures.setBackground(Color.WHITE);
        return pictures;
    }

    private JButton addButtonOnChoosingIllustration(Illustrations illustration) {
        JButton button = new JButton(FONT_COLOR_BLUE + illustration.name());
        button.setBorderPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(new ActionForNewIllustration(illustration.name(), this));
        button.setPreferredSize(new Dimension(WIDTH2, HEIGHT2));
        return button;
    }

    private JButton addButtonFromDatabase() {
        RequestToDatabase requestToDatabase = new RequestToDatabase();
        String[] lastPictures = requestToDatabase.getLastPictures();

        JButton button = new JButton(FONT_COLOR_BLUE + FINISH_THE_LAST_DRAWING);
        button.setBorderPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setPreferredSize(new Dimension(WIDTH2, HEIGHT2));

        if (lastPictures == null) {
            return button;
        }

        button.addActionListener(new ActionForOldIllustration(lastPictures[1], lastPictures[TWO], this));
        return button;
    }

    private JButton addUndoOnChoosingIllustration() {
        JButton undo = new JButton(BACK);
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

