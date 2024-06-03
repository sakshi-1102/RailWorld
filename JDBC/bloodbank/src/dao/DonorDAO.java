package dao;

import model.Donor;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonorDAO {
    public void addDonor(Donor donor) throws SQLException {
        String sql = "INSERT INTO Donor (name, blood_group, contact_number, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, donor.getName());
            stmt.setString(2, donor.getBloodGroup());
            stmt.setString(3, donor.getContactNumber());
            stmt.setString(4, donor.getEmail());
            stmt.executeUpdate();
        }
    }

    public List<Donor> getAllDonors() throws SQLException {
        List<Donor> donors = new ArrayList<>();
        String sql = "SELECT * FROM Donor";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Donor donor = new Donor();
                donor.setId(rs.getInt("id"));
                donor.setName(rs.getString("name"));
                donor.setBloodGroup(rs.getString("blood_group"));
                donor.setContactNumber(rs.getString("contact_number"));
                donor.setEmail(rs.getString("email"));
                donors.add(donor);
            }
        }
        return donors;
    }

    public Donor getDonorById(int id) throws SQLException {
        String sql = "SELECT * FROM Donor WHERE id = ?";
        Donor donor = null;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                donor = new Donor();
                donor.setId(rs.getInt("id"));
                donor.setName(rs.getString("name"));
                donor.setBloodGroup(rs.getString("blood_group"));
                donor.setContactNumber(rs.getString("contact_number"));
                donor.setEmail(rs.getString("email"));
            }
        }
        return donor;
    }

    public void updateDonor(Donor donor) throws SQLException {
        String sql = "UPDATE Donor SET name = ?, blood_group = ?, contact_number = ?, email = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, donor.getName());
            stmt.setString(2, donor.getBloodGroup());
            stmt.setString(3, donor.getContactNumber());
            stmt.setString(4, donor.getEmail());
            stmt.setInt(5, donor.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteDonor(int id) throws SQLException {
        String sql = "DELETE FROM Donor WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

