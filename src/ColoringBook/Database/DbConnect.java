package ColoringBook.Database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DbConnect {
    private final String URL = "jdbc:postgresql://localhost/ColoringBook?user=postgres&password=381381381Gg!";
    private static final String INSERT_COLORINGBOOK = "INSERT INTO ColoringBook" +
            "  (id, illustration, positionOfColors) VALUES " +
            " (?, ?, ?);";
    private final String COUNT_COLORINGBOOK = """
            select count(id)
            from ColoringBook
            """;
    private final String SELECT_COLORINGBOOK = """
            SELECT * 
            from ColoringBook
            """;
    public Map<Integer, String[]> executeSelect(String select, String[] columns) {
        Map<Integer, String[]> obj = new HashMap<>();
        try {
            Connection conn = DriverManager.getConnection(URL);
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

    public void executeInsert(int id, String[] values) {
        try (
                Connection conn = DriverManager.getConnection(URL);
                PreparedStatement preparedStatement = conn.prepareStatement(INSERT_COLORINGBOOK)) {

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, values[0]);
            preparedStatement.setString(3, values[1]);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot connect to DB: " + e.getMessage());
        }
    }

    public int executeCount() {
        try (
                Connection conn = DriverManager.getConnection(URL);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(COUNT_COLORINGBOOK)) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("Cannot connect to DB: " + e.getMessage());
            return -99;
        }
    }
}
