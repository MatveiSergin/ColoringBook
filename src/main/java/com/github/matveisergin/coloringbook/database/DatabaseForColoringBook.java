package com.github.matveisergin.coloringbook.database;

import com.github.matveisergin.coloringbook.cofig.PropertiesFactory;
import com.github.matveisergin.coloringbook.cofig.DatabaseProperties;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseForColoringBook {

    private static DatabaseForColoringBook instance;
    private final DatabaseProperties properties = PropertiesFactory.getProperties();
    private static final String SQL_QUERY_TO_EXECUTE_COUNT = """
            select count(%s)
            from Kursach.%s
            """;
    private static final String SQL_QUERY_TO_DELETE_EXECUTE = """
                DELETE FROM Kursach.%s
            WHERE id = (
                SELECT id
                FROM Kursach.%s
                ORDER BY id DESC
                LIMIT 1
            );
                """;
    private static final String SQL_QUERY_CREATE_SCHEMA = """
            create schema if not exists Kursach;
            """;
    private static final String SQL_QUERY_CREATE_TABLE_COLORINGBOOK = """
            create table if not exists Kursach.ColoringBook (
                id serial primary key,
                illustration varchar not null,
                positionOfColors varchar not null
            )
            """;
    private static final String SQL_QUERY_CREATE_TABLE_TEMPLATES = """
            create table if not exists Kursach.TemplatesForColoringBook
            (
                id integer not null primary key,
                name varchar not null,
                positionOfColors varchar not null
            );
            """;
    private static final String SQL_QUERY_INSERT_TEMPLATES = """
            insert into Kursach.TemplatesForColoringBook
            (id, name, positionOfColors) VALUES
            (1, 'Parrot', '111111133311111111111311331111111111316991111111111311991111111113331691111111113333111111111132223311111111322253311111111222253311111111444533111111114488533111111118855331111111115556611111111113517677777111113111111111111'),
            (2, 'Chicken', '111111111111111111111111111111111331111111111113551111111111115455111111511122555111115551113555511555551113555555555551111555555515511111555555515511111155155115111111155511155111111115555551111111111114111111111111114111111');
            """;
    private static final String COLUMN_NAME_FOR_COUNT_EXECUTE = "count";

    private static final String[] NAME_COLUMNS_FOR_COUNT = new String[]{"id", "TemplatesForColoringBook"};
    private static final String CANNOT_CONNECT_TO_DB = "Cannot connect to DB: ";

    private DatabaseForColoringBook() {
        init();
    }

    public synchronized static DatabaseForColoringBook getInstance() {
        if (instance == null) {
            instance = new DatabaseForColoringBook();
        }
        return instance;
    }

    public void execute(String sqlQuery) {
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            statement.execute(sqlQuery);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Map<Integer, String[]> selectAll(String select, String[] columns) {
        Map<Integer, String[]> obj = new HashMap<>();
        try {
            Connection conn = connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(select);
            int columnCounter = 0;
            while (rs.next()) {
                obj.put(columnCounter, new String[]{Integer.toString(rs.getInt(columns[0])), rs.getString(columns[1]), rs.getString(columns[2])});
                columnCounter += 1;
            }
            return obj;
        } catch (SQLException ex) {
            System.out.println(CANNOT_CONNECT_TO_DB + ex.getMessage());
            return Map.of();
        }
    }


    public int executeCount(String column, String tableName) {
        try (
                Connection conn = connect();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(String.format(SQL_QUERY_TO_EXECUTE_COUNT, column, tableName))) {
            if (resultSet.next()) {
                int count = resultSet.getInt(COLUMN_NAME_FOR_COUNT_EXECUTE);
                return count;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(CANNOT_CONNECT_TO_DB + e.getMessage());
            return 0;
        }
    }

    public void executeDeleteLastTuple(String tableName) {
        execute(String.format(SQL_QUERY_TO_DELETE_EXECUTE, tableName, tableName));
    }

    private void init() {
        createSchema();
        createTableColoringBook();
        createTableTemplates();
        insertTemplates();
    }

    private void createSchema() {
        execute(SQL_QUERY_CREATE_SCHEMA);
    }

    private void createTableColoringBook() {
        execute(SQL_QUERY_CREATE_TABLE_COLORINGBOOK);
    }

    private void createTableTemplates() {
        execute(SQL_QUERY_CREATE_TABLE_TEMPLATES);
    }

    private void insertTemplates() {
        if (executeCount(NAME_COLUMNS_FOR_COUNT[0], NAME_COLUMNS_FOR_COUNT[1]) == 0) {
            execute(SQL_QUERY_INSERT_TEMPLATES);
        }
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(
                properties.getUrl(),
                properties.getLogin(),
                properties.getPassword()
        );
    }
}
