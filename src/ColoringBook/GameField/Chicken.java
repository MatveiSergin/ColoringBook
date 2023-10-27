package ColoringBook.GameField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Chicken extends Illustration {
    private final String name = "Chicken";
    private final int width = 15;
    private String positionOfColors;

    private final ArrayList<AllColours> colors = new ArrayList<>(Arrays.asList(
            AllColours.WHITE,
            AllColours.YELLOW,
            AllColours.RED,
            AllColours.BLACK,
            AllColours.BROWN
    ));

    public Chicken() throws IOException {
        readFile(name);
    }

    public int getWidth() {
        return width;
    }

    @Override
    public ArrayList<AllColours> getColors() {
        return colors;
    }
}
