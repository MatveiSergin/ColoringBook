package ColoringBook.GameField;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {

    private Colour colour;
    private final int number;
    private final int index;

    public Cell(int numberColor, int number, int index, Palette palette) {
        this.number = number;
        this.index = index;
        colour = new Colour(numberColor, palette);
        setText(String.valueOf(number));
        setFont(new Font("Arial",Font.BOLD, 14));
        setBackground(this.colour.getColour());
    }

    public void setColour(Colour colour) {
        this.colour = colour;
        setBackground(this.colour.getColour());

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
