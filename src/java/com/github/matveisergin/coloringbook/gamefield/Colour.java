package com.github.matveisergin.coloringbook.gamefield;

import javax.swing.*;
import java.awt.*;

public class Colour extends JButton {

    private Color color;
    private int number;
    private String name = null;
    private boolean isSelected = false;
    private int[] rgb;

    Colour(AllColours baseColour, int number) {
        super(Integer.toString(number));
        this.number = number;
        this.rgb = baseColour.getRgb();
        this.color = getColour();
        this.name = baseColour.getName();
        setBackground(color);
        //setPreferredSize(new Dimension(50, 50));
        setFont(new Font("Arial", Font.BOLD, 14));
    }

    Colour(int number, Palette palette) {
        this.rgb = palette.getColours().get(number - 1).getRgb();
        this.number = number;
        getColour();
    }

    public Color getColour() {
        color = new Color(rgb[0], rgb[1], rgb[2]);
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

    public int[] getRgb() {
        return rgb;
    }
}