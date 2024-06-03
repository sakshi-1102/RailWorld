package service;

import dao.BloodInventoryDAO;
import model.BloodInventory;

import java.sql.SQLException;
import java.util.List;

public class BloodInventoryService {
    private BloodInventoryDAO bloodInventoryDAO;

    public BloodInventoryService() {
        bloodInventoryDAO = new BloodInventoryDAO();
    }

    public void addBloodInventory(BloodInventory bloodInventory) throws SQLException {
        bloodInventoryDAO.addBloodInventory(bloodInventory);
    }

    public BloodInventory getBloodInventoryById(int id) throws SQLException {
        return bloodInventoryDAO.getBloodInventoryById(id);
    }

    public List<BloodInventory> getAllBloodInventories() throws SQLException {
        return bloodInventoryDAO.getAllBloodInventories();
    }

    public void updateBloodInventory(BloodInventory bloodInventory) throws SQLException {
        bloodInventoryDAO.updateBloodInventory(bloodInventory);
    }

    public void deleteBloodInventory(int id) throws SQLException {
        bloodInventoryDAO.deleteBloodInventory(id);
    }
}

