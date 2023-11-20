package com.github.matveisergin.coloringbook.database;

import java.util.HashMap;
import java.util.Map;

public class RequestToDatabase {
    private final DatabaseForColoringBook databaseForColoringBook = DatabaseForColoringBook.getInstance();
    private final DatabaseForTemplates databaseForTemplates = DatabaseForTemplates.getInstance();
    public void savePictures(String nameIllustration, String positionOfColors) {
        String sql = """
                insert into Kursach.ColoringBook
                (illustration, positionOfColors)
                values
                ('%s', '%s')
                """;
        databaseForColoringBook.execute(String.format(sql, nameIllustration, positionOfColors));
    }

    public String[] getLastPictures() {
        String sql = """
                select *
                from Kursach.ColoringBook
                """;
        Map<Integer, String[]> allPictures = databaseForColoringBook.selectAll(sql, new String[] {"id", "illustration", "positionOfColors"});
        if (allPictures.size() == 0) {
            return null;
        }
        String[] lastPictures = allPictures.get(allPictures.size() - 1).clone();
        return lastPictures;
    }

    public Map<String, String> getTemplatesForColoringBook() {
        String sql = """
                select *
                from TemplatesForColoringBook
                """;
        Map<Integer, String[]> select = databaseForTemplates.selectAll(sql, new String[] {"id", "name", "positionOfColors"});
        Map<String, String> templates = new HashMap<>();
        for (int i = 0; i < select.size(); i++) {
            templates.put(select.get(i)[1], select.get(i)[2]);
        }
        return templates;
    }
}
