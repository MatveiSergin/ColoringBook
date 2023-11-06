package ColoringBook.Database;

import java.util.HashMap;
import java.util.Map;

public class RequestToDatabase implements IRequestToDatabase {
    public void savePictures(String nameIllustration, String positionOfColors) {
        DbConnect dbConnect = new DbConnect();
        int newId = dbConnect.executeCount() + 1;
        dbConnect.executeInsert(newId, new String[] {nameIllustration, positionOfColors});
    }

    public String[] getLastPictures() {
        DbConnect dbConnect = new DbConnect();
        Map<Integer, String[]> allPictures = dbConnect.executeSelect
                ("""
            SELECT * 
            from ColoringBook
            """, new String[] {"id", "illustration", "positionOfColors"});
        String[] lastPictures = allPictures.get(allPictures.size() - 1).clone();
        return lastPictures;
    }

    public Map<String, String> getTemplatesForColoringBook() {
        DbConnect dbConnect = new DbConnect();
        Map<Integer, String[]> select = dbConnect.executeSelect("""
                SELECT * 
                from TemplatesForColoringBook
                """, new String[] {"id", "name", "positionOfColors"});
        Map<String, String> templates = new HashMap<>();
        for (int i = 0; i < select.size(); i++) {
            templates.put(select.get(i)[1], select.get(i)[2]);
        }
        return templates;
    }
}
