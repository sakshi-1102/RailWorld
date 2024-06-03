package service;

import dao.BloodRequestDAO;
import model.BloodRequest;

import java.sql.SQLException;
import java.util.List;

public class BloodRequestService {
    private BloodRequestDAO bloodRequestDAO;

    public BloodRequestService() {
        bloodRequestDAO = new BloodRequestDAO();
    }

    public void addBloodRequest(BloodRequest bloodRequest) throws SQLException {
        bloodRequestDAO.addBloodRequest(bloodRequest);
    }

    public BloodRequest getBloodRequestById(int id) throws SQLException {
        return bloodRequestDAO.getBloodRequestById(id);
    }

    public List<BloodRequest> getAllBloodRequests() throws SQLException {
        return bloodRequestDAO.getAllBloodRequests();
    }

    public void updateBloodRequest(BloodRequest bloodRequest) throws SQLException {
        bloodRequestDAO.updateBloodRequest(bloodRequest);
    }

    public void deleteBloodRequest(int id) throws SQLException {
        bloodRequestDAO.deleteBloodRequest(id);
    }
}

