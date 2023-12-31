package com.github.matveisergin.coloringbook.gamefield;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Colour extends JButton {
    private Color color;
    private int number;
    private String name = null;
    private boolean isSelected = false;
    private int[] rgb;
    private static final String NAME_FONT = "Arial";
    private static final int FONT_SIZE = 14;
    private static final int THIRD_ELEMENT = 2;

    Colour(AllColours baseColour, int number) {
        super(Integer.toString(number));
        this.number = number;
        this.rgb = baseColour.getRgb();
        this.color = getColor();
        this.name = baseColour.name().toLowerCase();
        setBackground(color);
        setFont(new Font(NAME_FONT, Font.BOLD, FONT_SIZE));
    }

    public Color getColor() {
        color = new Color(rgb[0], rgb[1], rgb[THIRD_ELEMENT]);
        return color;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    public int getNumber() {
        return number;
    }
}