package dao;

import model.Staff;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {
    public void addStaff(Staff staff) throws SQLException {
        String sql = "INSERT INTO Staff (name, role, contact_number, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, staff.getName());
            stmt.setString(2, staff.getRole());
            stmt.setString(3, staff.getContactNumber());
            stmt.setString(4, staff.getEmail());
            stmt.executeUpdate();
        }
    }

    public List<Staff> getAllStaff() throws SQLException {
        List<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM Staff";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setId(rs.getInt("id"));
                staff.setName(rs.getString("name"));
                staff.setRole(rs.getString("role"));
                staff.setContactNumber(rs.getString("contact_number"));
                staff.setEmail(rs.getString("email"));
                staffList.add(staff);
            }
        }
        return staffList;
    }

    public Staff getStaffById(int id) throws SQLException {
        String sql = "SELECT * FROM Staff WHERE id=?";
        Staff staff = null;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    staff = new Staff();
                    staff.setId(rs.getInt("id"));
                    staff.setName(rs.getString("name"));
                    staff.setRole(rs.getString("role"));
                    staff.setContactNumber(rs.getString("contact_number"));
                    staff.setEmail(rs.getString("email"));
                }
            }
        }
        return staff;
    }

    public void updateStaff(Staff staff) throws SQLException {
        String sql = "UPDATE Staff SET name = ?, role = ?, contact_number = ?, email = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, staff.getName());
            stmt.setString(2, staff.getRole());
            stmt.setString(3, staff.getContactNumber());
            stmt.setString(4, staff.getEmail());
            stmt.setInt(5, staff.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteStaff(int id) throws SQLException {
        String sql = "DELETE FROM Staff WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
