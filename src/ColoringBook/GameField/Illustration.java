package ColoringBook.GameField;

import java.io.*;
import java.util.ArrayList;

public class Illustration {
    private String name;
    private String positionOfColors;
    private ArrayList<AllColours> colors;
    private int width;

    public void readFile(String name) throws IOException {
        String src = "C:\\workspace\\mai\\235\\23\\Kursach\\src\\ColoringBook\\Templates\\" + name + ".txt";
        FileInputStream fstream = new FileInputStream(src);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String result = br.readLine();
        this.positionOfColors = result;
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
}
