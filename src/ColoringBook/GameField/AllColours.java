package ColoringBook.GameField;

public enum AllColours {
    BLACK (new int[] {0, 0, 0}, "Black"),
    YELLOW (new int[] {255, 255, 0}, "Yellow"),
    RED (new int[] {255, 0, 0}, "Red"),
    GREEN (new int[] {0, 128, 0}, "Green"),
    BLUE (new int[] {0, 0, 255}, "Blue"),
    WHITE (new int[] {255, 255, 255}, "White"),
    BROWN (new int[] {150, 75, 0}, "Brown"),
    LIGHT_BLUE (new int[] {66, 170, 255}, "Light-blue"),
    LIGHT_YELLOW (new int[] {255, 255, 153}, "Light-yellow");

    private int[] rgb;
    private String name;

    AllColours(int[] rgb, String name) {
        this.rgb = rgb;
        this.name = name;
    }

    public int[] getRgb() {
        return rgb;
    }

    public String getName() {
        return name;
    }
}
