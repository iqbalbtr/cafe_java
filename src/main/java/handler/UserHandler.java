package handler;

import model.User;
import db.db;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserHandler {

    public void create(User user) throws SQLException {
        String query = "INSERT INTO users (nama, role, username, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            System.out.println(user.getNama() + user.getRole() + user.getUsername() + user.getPassword());
            
            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getRole());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new SQLException("Gagal menambahkan user", e);
        } finally {
            db.closeConnection();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new SQLException("User dengan ID " + id + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            throw new SQLException("Gagal menghapus user", e);
        } finally {
            db.closeConnection();
        }
    }

    public List<User> getAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (Connection conn = db.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("role"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                userList.add(user);
            }

        } catch (SQLException e) {
            throw new SQLException("Gagal mengambil data user", e);
        } finally {
            db.closeConnection();
        }

        return userList;
    }

    public void update(User user) throws SQLException {
        String query = "UPDATE users SET nama = ?, role = ?, username = ?, password = ? WHERE id = ?";
        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getRole());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("User dengan ID " + user.getId() + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            throw new SQLException("Gagal memperbarui user", e);
        } finally {
            db.closeConnection();
        }
    }
}
