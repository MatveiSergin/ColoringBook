package ColoringBook.GameField;

import java.util.*;

public class Action {
    private List<Map.Entry<Cell, Colour[]>> pairList = new ArrayList<>();
    private List<Integer> currentResult = new ArrayList<>();
    private Illustration illustration;
    private int quantityWhiteCells;
    private String progress;

    public Action(Illustration illustration) {
        this.illustration = illustration;
        for (int i = 0; i < illustration.getWidth() * illustration.getWidth(); i++) {
            currentResult.add(1);
        }
        int counter = 0;
        String positionOfColors = illustration.getPositionOfColors();

        for (int i = 0; i < positionOfColors.length(); i++) {
            if (positionOfColors.charAt(i) == '1') {
                counter += 1;
            }
        }
        this.quantityWhiteCells = counter;

        this.progress = calculateProgress();
    }
    public Action(Illustration illustration, String positionOfColors) {
        this.illustration = illustration;
        for (int i = 0; i < illustration.getWidth() * illustration.getWidth(); i++) {
            currentResult.add(Character.getNumericValue(positionOfColors.charAt(i)));
        }
        int counter = 0;

        for (int i = 0; i < positionOfColors.length(); i++) {
            if (positionOfColors.charAt(i) == '1') {
                counter += 1;
            }
        }
        this.quantityWhiteCells = counter;

        this.progress = calculateProgress();
    }

    public void addAction(Cell cell, Colour last_colour, Colour new_colour) {
        Colour[] array = new Colour[]{last_colour, new_colour};
        Map.Entry<Cell, Colour[]> pair = new AbstractMap.SimpleEntry<>(cell, array);
        pairList.add(pair);
        currentResult.set(cell.getIndex(), new_colour.getNumber());
        progress = calculateProgress();
    }

    public void removeLastAction() {
        if (!pairList.isEmpty()) {
            Map.Entry<Cell, Colour[]> Action = pairList.get(pairList.size() - 1);
            Cell cell = Action.getKey();
            Colour last_colour = Action.getValue()[0];
            cell.setColour(last_colour);
            pairList.remove(pairList.size() - 1);
            currentResult.set(cell.getIndex(), last_colour.getNumber());
            progress = calculateProgress();
        }
    }

    public void removeAllAction() {
        for (int i = pairList.size() - 1; i >= 0; i--) {
            Map.Entry<Cell, Colour[]> Action = pairList.get(i);
            Cell cell = Action.getKey();
            Colour last_colour = Action.getValue()[0];
            cell.setColour(last_colour);
        }
        for (int i = 0; i < illustration.getWidth() * illustration.getWidth(); i++) {
            currentResult.set(i, 1);
        }
        pairList.clear();
        progress = calculateProgress();
    }

    public String calculateProgress() {
        int counter = 0;
        String endResult = illustration.getPositionOfColors();

        for (int i = 0; i < currentResult.size(); i++) {
            if (currentResult.get(i) == Integer.parseInt(String.valueOf(endResult.charAt(i))) && currentResult.get(i) != 1) {
                counter += 1;
            }
        }

        float result = (float) counter * 100 / (225 - quantityWhiteCells) ;
        return String.format("%.1f", result);
    }

    public String getPositionOfColors() {
        String result = "";
        for (int numberColors :
                currentResult) {
            result += Integer.toString(numberColors);
        }
        return result;
    }
    public String getProgress() {
        return progress;
    }

    public String getNameOfIllustration() {
        return illustration.getName();
    }

    public List<Integer> getCurrentResult() {
        return currentResult;
    }
}
