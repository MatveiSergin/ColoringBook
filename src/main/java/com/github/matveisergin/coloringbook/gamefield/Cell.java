package com.github.matveisergin.coloringbook.gamefield;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {

    private Colour colour;
    private final int number;
    private final int index;
    private final String NAME_FONT = "Arial";
    private final int FONT_SIZE = 14;

    public Cell(int numberColor, int number, int index, Palette palette) {
        this.number = number;
        this.index = index;
        colour = palette.getColours().get(numberColor - 1);
        setText(String.valueOf(number));
        setFont(new Font(NAME_FONT, Font.BOLD, FONT_SIZE));
        setBackground(this.colour.getColor());
    }

    public void setColour(Colour colour) {
        this.colour = colour;
        setBackground(this.colour.getColor());

    }

    public int getNumber() {
        return number;
    }

    public Colour getColour() {
        return colour;
    }

    public int getIndex() {
        return index;
    }
}
