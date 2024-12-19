package handler;

import model.Item;
import db.db;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ItemTransaction;

public class ItemHandler {

    public void create(Item item) throws SQLException {
        String query = "INSERT INTO items (nama, jenis, stock, harga) VALUES (?, ?, ?, ?)";
        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, item.getNama());
            stmt.setString(2, item.getJenis());
            stmt.setInt(3, item.getStock());
            stmt.setLong(4, item.getHarga());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new SQLException("Gagal menambahkan item: " + e.getMessage(), e);
        } finally {
            db.closeConnection();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM items WHERE id = ?";
        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new SQLException("Item dengan ID " + id + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            throw new SQLException("Gagal menghapus item: " + e.getMessage(), e);
        } finally {
            db.closeConnection();
        }
    }

    public List<Item> getAll() throws SQLException {
        List<Item> itemList = new ArrayList<>();
        String query = "SELECT * FROM items";

        try (Connection conn = db.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Item item = new Item(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("jenis"),
                        rs.getInt("stock"),
                        rs.getLong("harga")
                );
                itemList.add(item);
            }
        } catch (SQLException e) {
            throw new SQLException("Gagal mengambil data item: " + e.getMessage(), e);
        } finally {
            db.closeConnection();
        }

        return itemList;
    }

    public List<Item> search(String search) throws SQLException {
        List<Item> itemList = new ArrayList<>();
        String query = "SELECT * FROM items WHERE nama LIKE ?";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + search + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item(
                            rs.getInt("id"),
                            rs.getString("nama"),
                            rs.getString("jenis"),
                            rs.getInt("stock"),
                            rs.getLong("harga")
                    );
                    itemList.add(item);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Gagal mengambil data item: " + e.getMessage(), e);
        }

        return itemList;
    }

    public void update(Item item) throws SQLException {
        String query = "UPDATE items SET nama = ?, jenis = ?, stock = ?, harga = ? WHERE id = ?";
        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, item.getNama());
            stmt.setString(2, item.getJenis());
            stmt.setInt(3, item.getStock());
            stmt.setLong(4, item.getHarga());
            stmt.setInt(5, item.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Item dengan ID " + item.getId() + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            throw new SQLException("Gagal memperbarui item: " + e.getMessage(), e);
        } finally {
            db.closeConnection();
        }
    }

}
