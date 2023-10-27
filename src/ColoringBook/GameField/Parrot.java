package ColoringBook.GameField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Parrot extends Illustration {
    private final String name = "Parrot";
    private final int width = 15;
    private String positionOfColors;

    private final ArrayList<AllColours> colors = new ArrayList<>(Arrays.asList(
                    AllColours.WHITE,
                    AllColours.YELLOW,
                    AllColours.RED,
                    AllColours.GREEN,
                    AllColours.BLUE,
                    AllColours.BLACK,
                    AllColours.BROWN,
                    AllColours.LIGHT_BLUE,
                    AllColours.LIGHT_YELLOW
                    ));

    public Parrot() throws IOException {
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
