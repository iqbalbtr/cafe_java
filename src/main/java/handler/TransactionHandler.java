package handler;

import db.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;

public class TransactionHandler {

    public void create(String buyer, long total, List<ItemCart> items) throws SQLException {
        String query = "INSERT INTO transactions (pembeli, total) VALUES (?, ?)";

        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, buyer);
            stmt.setLong(2, total);
            stmt.executeUpdate();

            int transactionId = -1;
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    transactionId = rs.getInt(1);
                }
            }

            if (transactionId == -1) {
                throw new SQLException("Gagal mendapatkan ID transaksi.");
            }

            String queryItem = "INSERT INTO transaction_items (transactions_id, qty, sub_total, item_id) VALUES (?, ?, ?, ?)";
            String queryUpdateItem = "UPDATE items SET stock = stock - ? WHERE id = ?";

            for (ItemCart item : items) {
                try (PreparedStatement stmtItem = conn.prepareStatement(queryItem); PreparedStatement stmtUpdateItem = conn.prepareStatement(queryUpdateItem)) {

                    stmtItem.setInt(1, transactionId);
                    stmtItem.setInt(2, item.getQty());
                    stmtItem.setInt(3, (int) item.getSubTotal());
                    stmtItem.setInt(4, item.getId());
                    stmtItem.executeUpdate();

                    stmtUpdateItem.setInt(1, item.getQty());
                    stmtUpdateItem.setInt(2, item.getId());
                    stmtUpdateItem.executeUpdate();
                }
            }

        } catch (SQLException e) {
            throw new SQLException("Gagal menambahkan transaksi: " + e.getMessage(), e);
        } finally {
            db.closeConnection();
        }
    }

    public void delete(int transactionId) throws SQLException {
        String deleteItemsQuery = "DELETE FROM transaction_items WHERE transactions_id = ?";
        String deleteTransactionQuery = "DELETE FROM transactions WHERE id = ?";

        try (Connection conn = db.getConnection(); PreparedStatement deleteItemsStmt = conn.prepareStatement(deleteItemsQuery); PreparedStatement deleteTransactionStmt = conn.prepareStatement(deleteTransactionQuery)) {

            deleteItemsStmt.setInt(1, transactionId);
            deleteItemsStmt.executeUpdate();

            deleteTransactionStmt.setInt(1, transactionId);
            int rowsDeleted = deleteTransactionStmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new SQLException("Transaksi dengan ID " + transactionId + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            throw new SQLException("Gagal menghapus transaksi: " + e.getMessage(), e);
        } finally {
            db.closeConnection();
        }
    }

    public void updateTransactionStatus(int transactionId, String newStatus) throws SQLException {
        String updateStatusQuery = "UPDATE transactions SET status = ? WHERE id = ?";

        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(updateStatusQuery)) {

            stmt.setString(1, newStatus);
            stmt.setInt(2, transactionId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Transaksi dengan ID " + transactionId + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            throw new SQLException("Gagal memperbarui status transaksi: " + e.getMessage(), e);
        } finally {
            db.closeConnection();
        }
    }

    public List<Transaction> getAll() throws SQLException {

        List<Transaction> transactionList = new ArrayList<>();

        String query = "SELECT * FROM transactions";
        try (Connection conn = db.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Transaction item = new Transaction(
                        rs.getInt("id"),
                        rs.getLong("total"),
                        rs.getString("pembeli"),
                        rs.getString("status")
                );
                transactionList.add(item);
            }
        } catch (SQLException e) {
            throw new SQLException("Gagal mengambil data transaksi: " + e.getMessage(), e);
        } finally {
            db.closeConnection();
        }

        return transactionList;
    }

    public List<ItemTransaction> getItemAll(int id) throws SQLException {
        List<ItemTransaction> itemList = new ArrayList<>();
        String query = "SELECT transaction_items.id, nama, qty, sub_total FROM transaction_items INNER JOIN items ON transaction_items.item_id = items.id WHERE transaction_items.transactions_id = ?;";

        try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ItemTransaction item = new ItemTransaction(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getLong("sub_total"),
                        rs.getInt("qty")
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

}
