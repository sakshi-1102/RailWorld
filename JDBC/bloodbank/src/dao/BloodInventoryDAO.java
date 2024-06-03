package dao;


import model.BloodInventory;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BloodInventoryDAO {

        public void addBloodInventory(BloodInventory bloodInventory) throws SQLException {
            String sql = "INSERT INTO BloodInventory (blood_group, quantity) VALUES (?, ?)";
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, bloodInventory.getBloodGroup());
                stmt.setInt(2, bloodInventory.getQuantity());
                stmt.executeUpdate();
            }
        }

        public List<BloodInventory> getAllBloodInventories() throws SQLException {
            List<BloodInventory> bloodInventories = new ArrayList<>();
            String sql = "SELECT * FROM BloodInventory";
            try (Connection conn = DBUtil.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    BloodInventory bloodInventory = new BloodInventory();
                    bloodInventory.setId(rs.getInt("id"));
                    bloodInventory.setBloodGroup(rs.getString("blood_group"));
                    bloodInventory.setQuantity(rs.getInt("quantity"));
                    bloodInventories.add(bloodInventory);
                }
            }
            return bloodInventories;
        }

        public BloodInventory getBloodInventoryById(int id) throws SQLException {
            String sql = "SELECT * FROM BloodInventory WHERE id=?";
            BloodInventory bloodInventory = null;
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        bloodInventory = new BloodInventory();
                        bloodInventory.setId(rs.getInt("id"));
                        bloodInventory.setBloodGroup(rs.getString("blood_group"));
                        bloodInventory.setQuantity(rs.getInt("quantity"));
                    }
                }
            }
            return bloodInventory;
        }

        public void updateBloodInventory(BloodInventory bloodInventory) throws SQLException {
            String sql = "UPDATE BloodInventory SET blood_group = ?, quantity = ? WHERE id = ?";
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, bloodInventory.getBloodGroup());
                stmt.setInt(2, bloodInventory.getQuantity());
                stmt.setInt(3, bloodInventory.getId());
                stmt.executeUpdate();
            }
        }

        public void deleteBloodInventory(int id) throws SQLException {
            String sql = "DELETE FROM BloodInventory WHERE id = ?";
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        }
    }


