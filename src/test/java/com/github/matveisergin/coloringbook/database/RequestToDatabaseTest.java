package com.github.matveisergin.coloringbook.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class RequestToDatabaseTest {
    private RequestToDatabase testRequest;
    private DatabaseForColoringBook testDb;
    private static final String[] NEW_CANVAS_FOR_SAVE = {"name_for_convas", "123456789"};
    private static final String[] COLUMN_AND_TABLE_FOR_EXECUTECOUNT = {"id", "ColoringBook"};
    private static final String TABLES_NAME = "ColoringBook";
    private static final Map<String, String> EXPECTED_RESULT = Map.of(
            "Parrot", "111111133311111111111311331111111111316991111111111311991111111113331691111111113333111111111132223311111111322253311111111222253311111111444533111111114488533111111118855331111111115556611111111113517677777111113111111111111",
            "Chicken", "111111111111111111111111111111111331111111111113551111111111115455111111511122555111115551113555511555551113555555555551111555555515511111555555515511111155155115111111155511155111111115555551111111111114111111111111114111111"
    );
    @BeforeEach
    void initDb() {
        testRequest = new RequestToDatabase();
        testDb = DatabaseForColoringBook.getInstance();
    }
    @Test
    void testSavePicturesMethod() {
        int counterTuplesBeforeInsert = testDb.executeCount(
                COLUMN_AND_TABLE_FOR_EXECUTECOUNT[0],
                COLUMN_AND_TABLE_FOR_EXECUTECOUNT[1]
        );
        testRequest.savePictures(NEW_CANVAS_FOR_SAVE[0], NEW_CANVAS_FOR_SAVE[1]);
        int counterTuplesAfterInsert = testDb.executeCount(
                COLUMN_AND_TABLE_FOR_EXECUTECOUNT[0],
                COLUMN_AND_TABLE_FOR_EXECUTECOUNT[1]
        );
        Assertions.assertEquals(counterTuplesBeforeInsert + 1, counterTuplesAfterInsert);
        testDb.executeDeleteLastTuple(TABLES_NAME);
    }

    @Test
    void testGetLastPicturesMethod() {
        testRequest.savePictures(NEW_CANVAS_FOR_SAVE[0], NEW_CANVAS_FOR_SAVE[1]);
        String[] lastPicturesWithId = testRequest.getLastPictures();
        String[] lastPicturesWithoutId = new String[] {lastPicturesWithId[1], lastPicturesWithId[1 + 1]};
        Assertions.assertArrayEquals(NEW_CANVAS_FOR_SAVE, lastPicturesWithoutId);
        testDb.executeDeleteLastTuple(TABLES_NAME);
    }

    @Test
    void testGetTemplatesForColoringBookMethod() {
        Map<String, String> testResult = testRequest.getTemplatesForColoringBook();
        Assertions.assertEquals(testResult.size(), EXPECTED_RESULT.size());
        Assertions.assertArrayEquals(testResult.values().toArray(), EXPECTED_RESULT.values().toArray());
    }
}
