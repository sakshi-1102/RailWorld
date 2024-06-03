package dao;

import model.BloodRequest;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BloodRequestDAO {
    public void addBloodRequest(BloodRequest bloodRequest) throws SQLException {
        String sql = "INSERT INTO BloodRequest (patient_name, blood_group, quantity, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bloodRequest.getPatientName());
            stmt.setString(2, bloodRequest.getBloodGroup());
            stmt.setInt(3, bloodRequest.getQuantity());
            stmt.setString(4, bloodRequest.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<BloodRequest> getAllBloodRequests() throws SQLException {
        List<BloodRequest> bloodRequests = new ArrayList<>();
        String sql = "SELECT * FROM BloodRequest";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                BloodRequest bloodRequest = new BloodRequest();
                bloodRequest.setId(rs.getInt("id"));
                bloodRequest.setPatientName(rs.getString("patient_name"));
                bloodRequest.setBloodGroup(rs.getString("blood_group"));
                bloodRequest.setQuantity(rs.getInt("quantity"));
                bloodRequest.setStatus(rs.getString("status"));
                bloodRequests.add(bloodRequest);
            }
        }
        return bloodRequests;
    }

    public BloodRequest getBloodRequestById(int id) throws SQLException {
        String sql = "SELECT * FROM BloodRequest WHERE id=?";
        BloodRequest bloodRequest = null;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    bloodRequest = new BloodRequest();
                    bloodRequest.setId(rs.getInt("id"));
                    bloodRequest.setPatientName(rs.getString("patient_name"));
                    bloodRequest.setBloodGroup(rs.getString("blood_group"));
                    bloodRequest.setQuantity(rs.getInt("quantity"));
                    bloodRequest.setStatus(rs.getString("status"));
                }
            }
        }
        return bloodRequest;
    }

    public void updateBloodRequest(BloodRequest bloodRequest) throws SQLException {
        String sql = "UPDATE BloodRequest SET patient_name = ?, blood_group = ?, quantity = ?, status = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bloodRequest.getPatientName());
            stmt.setString(2, bloodRequest.getBloodGroup());
            stmt.setInt(3, bloodRequest.getQuantity());
            stmt.setString(4, bloodRequest.getStatus());
            stmt.setInt(5, bloodRequest.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteBloodRequest(int id) throws SQLException {
        String sql = "DELETE FROM BloodRequest WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
