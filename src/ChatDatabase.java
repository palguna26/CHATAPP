import java.sql.*;

public class ChatDatabase {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:chat.db")) {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS messages (id INTEGER PRIMARY KEY, sender TEXT, message TEXT)";
            stmt.executeUpdate(sql);
            System.out.println("Chat table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
