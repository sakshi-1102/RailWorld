package service;

import dao.DonorDAO;
import model.Donor;

import java.sql.SQLException;
import java.util.List;

public class DonorService {
    private DonorDAO donorDAO = new DonorDAO();

    public void addDonor(Donor donor) throws SQLException {
        donorDAO.addDonor(donor);
    }

    public Donor getDonorById(int id) throws SQLException {
        return donorDAO.getDonorById(id);
    }

    public List<Donor> getAllDonors() throws SQLException {
        return donorDAO.getAllDonors();
    }

    public void updateDonor(Donor donor) throws SQLException {
        donorDAO.updateDonor(donor);
    }

    public void deleteDonor(int id) throws SQLException {
        donorDAO.deleteDonor(id);
    }
}


