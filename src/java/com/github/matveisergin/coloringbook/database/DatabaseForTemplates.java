package com.github.matveisergin.coloringbook.database;
import com.github.matveisergin.coloringbook.cofig.PropertiesFactory;
import com.github.matveisergin.coloringbook.cofig.DatabaseProperties;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseForTemplates {

    private static DatabaseForTemplates instance;
    private final DatabaseProperties properties = PropertiesFactory.getProperties();

    public DatabaseForTemplates() {
        init();
    }

    public synchronized static DatabaseForTemplates getInstance() {
        if (instance == null) {
            instance = new DatabaseForTemplates();
        }
        return instance;
    }

    private void init() {
        createSchema();
        createTableTemplates();
        insertTemplates();
    }

    private void createSchema() {
        String sql = """
                create schema if not exists Kursach;
                """;
        execute(sql);
    }

    private void createTableTemplates() {
        String sql = """
                create table if not exists Kursach.TemplatesForColoringBook
                (
                    id integer not null primary key,
                    name varchar not null,
                    positionOfColors varchar not null
                );
                """;
        execute(sql);
    }

    private void insertTemplates() {
        if (executeCount() == 0) {
            String sql = """
                    insert into TemplatesForColoringBook
                    (id, name, positionOfColors) VALUES
                    (1, 'Parrot', '111111133311111111111311331111111111316991111111111311991111111113331691111111113333111111111132223311111111322253311111111222253311111111444533111111114488533111111118855331111111115556611111111113517677777111113111111111111'),
                    (2, 'Chicken', '111111111111111111111111111111111331111111111113551111111111115455111111511122555111115551113555511555551113555555555551111555555515511111555555515511111155155115111111155511155111111115555551111111111114111111111111114111111');
                    """;
            execute(sql);
        }
    }

    private int executeCount() {
        String sql = """
                select count(id)
                from TemplatesForColoringBook
                """;
        try (
                Connection conn = connect();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("Cannot connect to DB: " + e.getMessage());
            return 0;
        }
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
