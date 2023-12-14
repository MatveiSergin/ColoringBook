package com.github.matveisergin.coloringbook.gamefield;

public enum AllColours {
    BLACK(new int[]{0, 0, 0}),
    YELLOW(new int[]{255, 255, 0}),
    RED(new int[]{255, 0, 0}),
    GREEN(new int[]{0, 128, 0}),
    BLUE(new int[]{0, 0, 255}),
    WHITE(new int[]{255, 255, 255}),
    BROWN(new int[]{150, 75, 0}),
    LIGHT_BLUE(new int[]{66, 170, 255}),
    LIGHT_YELLOW(new int[]{255, 255, 153});

    private int[] rgb;

    AllColours(int[] rgb) {
        this.rgb = rgb;
    }

    public int[] getRgb() {
        return rgb;
    }
}
