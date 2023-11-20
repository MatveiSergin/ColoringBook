package com.github.matveisergin.coloringbook.gamefield;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Palette extends JPanel {
    private ArrayList<Colour> colours = new ArrayList<>(9);

    public Palette() {
        super(new GridLayout(3, 3, 10, 10));
    }

    public void addColour(Colour colour) {
        colours.add(colour);
        add(colour);
    }

    public ArrayList<Colour> getColours() {
        return colours;
    }
}
