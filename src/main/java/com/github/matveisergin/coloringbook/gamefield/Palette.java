package com.github.matveisergin.coloringbook.gamefield;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Palette extends JPanel {
    private ArrayList<Colour> colours = new ArrayList<>(INITIAL_CAPACITY);
    private static final int INITIAL_CAPACITY = 9;
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final int HGAP = 10;
    private static final int VGAP = 10;

    public Palette() {
        super(new GridLayout(ROWS, COLS, HGAP, VGAP));
    }

    public void addColour(Colour colour) {
        colours.add(colour);
        add(colour);
    }

    public ArrayList<Colour> getColours() {
        return colours;
    }
}
