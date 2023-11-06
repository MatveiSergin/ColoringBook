package ColoringBook.Database;

import java.util.Map;

public interface IRequestToDatabase {
    void savePictures(String nameIllustration, String positionOfColors);
    String[] getLastPictures();
    Map<String, String> getTemplatesForColoringBook();
}
