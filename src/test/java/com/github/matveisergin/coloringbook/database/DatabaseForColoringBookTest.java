package com.github.matveisergin.coloringbook.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class DatabaseForColoringBookTest {
    DatabaseForColoringBook testDb;

    private static final String[] COLUMNS = {"id", "name", "positionOfColors"};
    private static final String SELECT_QUERY_FOR_SELECTALL = """
                SELECT *
                FROM Kursach.TemplatesForColoringBook
                """;
    private static final int EXPECTED_SIZE = 2;
    private static final Map<Integer, String[]> EXPECTED_RESULT = Map.of(
            0, new String[] {"1", "Parrot", "111111133311111111111311331111111111316991111111111311991111111113331691111111113333111111111132223311111111322253311111111222253311111111444533111111114488533111111118855331111111115556611111111113517677777111113111111111111"},
            1, new String[] {"2", "Chicken", "111111111111111111111111111111111331111111111113551111111111115455111111511122555111115551113555511555551113555555555551111555555515511111555555515511111155155115111111155511155111111115555551111111111114111111111111114111111"}
            );
    private static final int EXPECTED_COUNT = 2;
    private static final String QUERY_INSERT_TUPLE_FOR_TEMPLATES = """
            INSERT INTO Kursach.TemplatesForColoringBook
            (id, name, positionOfColors) VALUES
            (3, 'testing', '123456789');
            """;
    private static final String TABLES_NAME_FOR_TEMPLATES = "TemplatesForColoringBook";
    @BeforeEach
    void initDb() {
        testDb = DatabaseForColoringBook.getInstance();
    }
    @Test
    void testGetInstanceMethods() {
        DatabaseForColoringBook db2 = DatabaseForColoringBook.getInstance();
        Assertions.assertNotNull(testDb);
        Assertions.assertNotNull(db2);
        Assertions.assertEquals(testDb, db2);
    }

    @Test
    void testSelectAllMethod() {
        Map<Integer, String[]> result = testDb.selectAll(SELECT_QUERY_FOR_SELECTALL, COLUMNS);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(EXPECTED_SIZE, result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertArrayEquals(EXPECTED_RESULT.get(i), result.get(i));
        }
    }

    @Test
    void testExecuteCountMethod()  {
        int firstResult = testDb.executeCount(COLUMNS[0], TABLES_NAME_FOR_TEMPLATES);
        Assertions.assertEquals(EXPECTED_COUNT, firstResult);
        testDb.execute(QUERY_INSERT_TUPLE_FOR_TEMPLATES);
        int secondResult = testDb.executeCount(COLUMNS[0], TABLES_NAME_FOR_TEMPLATES);
        Assertions.assertEquals(EXPECTED_COUNT + 1, secondResult);
        testDb.executeDeleteLastTuple(TABLES_NAME_FOR_TEMPLATES);
    }
}
