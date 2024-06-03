package service;

import dao.StaffDAO;
import model.Staff;

import java.sql.SQLException;
import java.util.List;

public class StaffService {
    private StaffDAO staffDAO;

    public StaffService() {
        staffDAO = new StaffDAO();
    }

    public void addStaff(Staff staff) throws SQLException {
        staffDAO.addStaff(staff);
    }

    public Staff getStaffById(int id) throws SQLException {
        return staffDAO.getStaffById(id);
    }

    public List<Staff> getAllStaff() throws SQLException {
        return staffDAO.getAllStaff();
    }

    public void updateStaff(Staff staff) throws SQLException {
        staffDAO.updateStaff(staff);
    }

    public void deleteStaff(int id) throws SQLException {
        staffDAO.deleteStaff(id);
    }
}


