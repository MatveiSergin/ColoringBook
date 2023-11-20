package com.github.matveisergin.coloringbook.database;
import com.github.matveisergin.coloringbook.cofig.PropertiesFactory;
import com.github.matveisergin.coloringbook.cofig.DatabaseProperties;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseForColoringBook {

    private static DatabaseForColoringBook instance;
    private final DatabaseProperties properties = PropertiesFactory.getProperties();

    public DatabaseForColoringBook() {
        init();
    }

    public synchronized static DatabaseForColoringBook getInstance() {
        if (instance == null) {
            instance = new DatabaseForColoringBook();
        }
        return instance;
    }

    private void init() {
        createSchema();
        createTableColoringBook();
    }

    private void createSchema() {
        String sql = """
                create schema if not exists Kursach;
                """;
        execute(sql);
    }

    private void createTableColoringBook() {
        String sql = """
                create table if not exists Kursach.ColoringBook (
                    id serial primary key,
                    illustration varchar not null,
                    positionOfColors varchar not null
                )
                """;
        execute(sql);
    }

    public void execute(String sql) {
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
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
            System.out.println("Cannot connect to DB: " + ex.getMessage());
            return Map.of();
        }
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(
                properties.getUrl(),
                properties.getLogin(),
                properties.getPassword()
        );

    }
}
