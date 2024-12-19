package handler;

import db.db;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class AuthHandler {

    public User login(String username, String password) throws SQLException {
        Connection conn = db.getConnection();

        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (password.equals(dbPassword)) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("nama"),
                            rs.getString("role"),
                            "--",
                            rs.getString("username")
                    );
                } else {
                    System.err.println("Password salah!");
                }
            } else {
                System.err.println("Username tidak ditemukan!");
            }
        } catch (SQLException e) {
            System.err.println("Kesalahan SQL: " + e.getMessage());
        } finally {
            db.closeConnection();
        }

        return null;
    }
    
}

