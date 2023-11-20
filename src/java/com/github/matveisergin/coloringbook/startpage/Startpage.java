package com.github.matveisergin.coloringbook.startpage;

import com.github.matveisergin.coloringbook.startpage.button.actions.ActionExit;
import com.github.matveisergin.coloringbook.startpage.button.actions.ActionStartGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Startpage extends JFrame {
    public Startpage() throws IOException {
        super("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 700);
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

        JLabel background = new JLabel(new ImageIcon(ImageIO.read(new File("C:\\workspace\\mai\\235\\23\\Kursach\\src\\java\\com\\github\\matveisergin\\coloringbook\\media\\pallete.png"))));
        background.setOpaque(true);
        background.setBackground(Color.WHITE);

        JLabel name = new JLabel("Welcome to the Coloring book!!");
        name.setFont(new Font("Verdana", Font.ITALIC, 20));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setForeground(Color.red);
        name.setOpaque(true);
        name.setBackground(Color.white);
        name.setPreferredSize(new Dimension(350, 100));

        JButton startGame = new JButton("<html><h2><font color=\"blue\">Start game!");
        startGame.addActionListener(new ActionStartGame(this));
        startGame.setBorderPainted(false);
        startGame.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        startGame.setFocusPainted(false);
        startGame.setContentAreaFilled(false);

        JButton exit = new JButton("<html><h2><font color=\"blue\">Exit");
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
