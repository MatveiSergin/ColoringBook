package com.github.matveisergin.coloringbook.startpage;

import com.github.matveisergin.coloringbook.startpage.button.actions.ActionExit;
import com.github.matveisergin.coloringbook.startpage.button.actions.ActionStartGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Startpage extends JFrame {

    private static final String MENU = "Menu";
    private static final String FILE_PATH_TO_PICTURE_WITH_PALETTE = "pallete.png";
    private static final String WELCOME = "Welcome to the Coloring book!!";
    private static final int WIDTH1 = 350;
    private static final int HEIGHT1 = 100;
    private static final String START_GAME = "<html><h2><font color=\"blue\">Start game!";
    private static final String EXIT = "<html><h2><font color=\"blue\">Exit";
    private static final int[] WINDOW_RESOLUTION = new int[]{350, 700};
    private static final int FONT_SIZE = 20;
    private static final String FONT_NAME = "Verdana";

    public Startpage() throws IOException {
        super(MENU);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_RESOLUTION[0], WINDOW_RESOLUTION[1]);
        setBackground(Color.white);
        setLocationRelativeTo(null);
        fillStartPage();
    }

    public void outputFrame() {
        setVisible(true);
    }

    private void fillStartPage() throws IOException  {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel background = new JLabel(new ImageIcon(ImageIO.read(new File(Thread.currentThread().getContextClassLoader().getResource(FILE_PATH_TO_PICTURE_WITH_PALETTE).getPath()))));
        background.setOpaque(true);
        background.setBackground(Color.WHITE);

        JLabel name = new JLabel(WELCOME);
        name.setFont(new Font(FONT_NAME, Font.ITALIC, FONT_SIZE));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setForeground(Color.red);
        name.setOpaque(true);
        name.setBackground(Color.white);
        name.setPreferredSize(new Dimension(WIDTH1, HEIGHT1));

        JButton startGame = new JButton(START_GAME);
        startGame.addActionListener(new ActionStartGame(this));
        startGame.setBorderPainted(false);
        startGame.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        startGame.setFocusPainted(false);
        startGame.setContentAreaFilled(false);

        JButton exit = new JButton(EXIT);
        exit.addActionListener(new ActionExit());
        exit.setBorderPainted(false);
        exit.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        exit.setFocusPainted(false);
        exit.setContentAreaFilled(false);

        panel.add(Box.createHorizontalGlue());
        panel.add(startGame);
        panel.add(Box.createHorizontalGlue());
        panel.add(exit);
        panel.add(Box.createHorizontalGlue());
        panel.setBackground(Color.white);

        add(background, BorderLayout.SOUTH);
        add(name, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }
}
