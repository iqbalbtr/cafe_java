package handler;

import db.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DashboardHandler {

    public Map<String, Integer> countItemsByTable() throws SQLException {
        String queryUser = "SELECT COUNT(*) FROM users";
        String queryTransaction = "SELECT COUNT(*) FROM transactions";
        String queryItem = "SELECT COUNT(*) FROM items";

        Map<String, Integer> counts = new HashMap<>();

        try (
                Connection conn = db.getConnection(); 
                PreparedStatement stmtUser = conn.prepareStatement(queryUser); 
                PreparedStatement stmtTransaction = conn.prepareStatement(queryTransaction); 
                PreparedStatement stmtItem = conn.prepareStatement(queryItem);
            ) {
            
            try (ResultSet rsUser = stmtUser.executeQuery()) {
                if (rsUser.next()) {
                    counts.put("users", rsUser.getInt(1));
                }
            }

            try (ResultSet rsTransaction = stmtTransaction.executeQuery()) {
                if (rsTransaction.next()) {
                    counts.put("transactions", rsTransaction.getInt(1));
                }
            }

            try (ResultSet rsItem = stmtItem.executeQuery()) {
                if (rsItem.next()) {
                    counts.put("items", rsItem.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Gagal menghitung data: " + e.getMessage(), e);
        } finally {
            db.closeConnection();
        }

        return counts;
    }

}
