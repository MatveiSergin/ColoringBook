package com.github.matveisergin.coloringbook.gamefield;

import com.github.matveisergin.coloringbook.database.RequestToDatabase;

import java.util.ArrayList;
import java.util.Map;

public abstract class Illustration {
    private String name;
    private String positionOfColors;
    private ArrayList<AllColours> colors;
    private int width;

    public Illustration(String name, ArrayList<AllColours> colors, int width) {
        this.name = name;
        this.colors = colors;
        this.width = width;
        setPositionOfColors();
    }

    public String getPositionOfColors() {
        return positionOfColors;
    }

    public ArrayList<AllColours> getColors() {
        return colors;
    }

    public int getWidth() {
        return width;
    }

    public String getName() {
        return name;
    }

    private void setPositionOfColors() {
        RequestToDatabase requestToDatabase = new RequestToDatabase();
        Map<String, String> templates = requestToDatabase.getTemplatesForColoringBook();
        positionOfColors = templates.get(name);
    }
}
