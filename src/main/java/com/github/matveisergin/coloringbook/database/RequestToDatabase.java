package com.github.matveisergin.coloringbook.database;

import java.util.HashMap;
import java.util.Map;

public class RequestToDatabase {

    private final String SQL_QUERY_FOR_SAVE_PICTURES = """
            insert into Kursach.ColoringBook
            (illustration, positionOfColors)
            values
            ('%s', '%s')
            """;
    private final String SQL_QUERY_FOR_GET_LAST_PICTURES = """
            select *
            from Kursach.ColoringBook
            """;
    private final String SQL_QUERY_FOR_GET_TEMPLATES = """
            select *
            from TemplatesForColoringBook
            """;
    private final String FIRST_COLUMN_FOR_COLORINGBOOK = "id";
    private final String SECOND_COLUMN_FOR_COLORINGBOOK = "illustration";
    private final String THIRD_COLUMN_FOR_COLORINGBOOK = "positionOfColors";
    private final String FIRST_COLUMN_FOR_TEMPLATES = "id";
    private final String SECOND_COLUMN_FOR_TEMPLATES = "name";
    private final String THIRD_COLUMN_FOR_TEMPLATES = "positionOfColors";
    private final int THIRD_ELEMENT = 2;
    private final DatabaseForColoringBook database = DatabaseForColoringBook.getInstance();

    public void savePictures(String nameIllustration, String positionOfColors) {
        database.execute(String.format(SQL_QUERY_FOR_SAVE_PICTURES, nameIllustration, positionOfColors));
    }

    public String[] getLastPictures() {
        Map<Integer, String[]> allPictures = database.selectAll(SQL_QUERY_FOR_GET_LAST_PICTURES, new String[]{
                FIRST_COLUMN_FOR_COLORINGBOOK,
                SECOND_COLUMN_FOR_COLORINGBOOK,
                THIRD_COLUMN_FOR_COLORINGBOOK
        });
        if (allPictures.isEmpty()) {
            return null;
        }
        String[] lastPictures = allPictures.get(allPictures.size() - 1);
        return lastPictures;
    }

    public Map<String, String> getTemplatesForColoringBook() {
        Map<Integer, String[]> select = database.selectAll(
                SQL_QUERY_FOR_GET_TEMPLATES,
                new String[]{
                        FIRST_COLUMN_FOR_TEMPLATES,
                        SECOND_COLUMN_FOR_TEMPLATES,
                        THIRD_COLUMN_FOR_TEMPLATES
                });

        Map<String, String> templates = new HashMap<>();
        for (int i = 0; i < select.size(); i++) {
            templates.put(select.get(i)[1], select.get(i)[THIRD_ELEMENT]);
        }
        return templates;
    }
}
