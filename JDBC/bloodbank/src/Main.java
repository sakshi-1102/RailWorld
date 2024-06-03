import model.*;
import service.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private DonorService donorService;
    private BloodInventoryService bloodInventoryService;
    private BloodRequestService bloodRequestService;
    private StaffService staffService;
    private Scanner scanner;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public Main() {
        donorService = new DonorService();
        bloodInventoryService = new BloodInventoryService();
        bloodRequestService = new BloodRequestService();
        staffService = new StaffService();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMainMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        manageDonors();
                        break;
                    case 2:
                        manageBloodInventory();
                        break;
                    case 3:
                        manageBloodRequests();
                        break;
                    case 4:
                        manageStaff();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\nBlood Bank Management System");
        System.out.println("1. Manage Donors");
        System.out.println("2. Manage Blood Inventory");
        System.out.println("3. Manage Blood Requests");
        System.out.println("4. Manage Staff");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Donor Management
    private void manageDonors() throws SQLException {
        while (true) {
            showDonorMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addDonor();
                    break;
                case 2:
                    viewAllDonors();
                    break;
                case 3:
                    updateDonor();
                    break;
                case 4:
                    deleteDonor();
                    break;
                case 5:
                    viewDonorById();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void showDonorMenu() {
        System.out.println("\nDonor Management");
        System.out.println("1. Add Donor");
        System.out.println("2. View All Donors");
        System.out.println("3. Update Donor");
        System.out.println("4. Delete Donor");
        System.out.println("5. View Donor by ID");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private void addDonor() throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter blood group: ");
        String bloodGroup = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Donor donor = new Donor();
        donor.setName(name);
        donor.setBloodGroup(bloodGroup);
        donor.setContactNumber(contactNumber);
        donor.setEmail(email);

        donorService.addDonor(donor);
        System.out.println("Donor added successfully!");
    }

    private void viewAllDonors() throws SQLException {
        List<Donor> donors = donorService.getAllDonors();
        System.out.println("\nDonor List:");
        for (Donor donor : donors) {
            System.out.println(donor);
        }
    }

    private void updateDonor() throws SQLException {
        System.out.print("Enter donor ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new blood group: ");
        String bloodGroup = scanner.nextLine();
        System.out.print("Enter new contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        Donor donor = new Donor();
        donor.setId(id);
        donor.setName(name);
        donor.setBloodGroup(bloodGroup);
        donor.setContactNumber(contactNumber);
        donor.setEmail(email);

        donorService.updateDonor(donor);
        System.out.println("Donor updated successfully!");
    }

    private void deleteDonor() throws SQLException {
        System.out.print("Enter donor ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        donorService.deleteDonor(id);
        System.out.println("Donor deleted successfully!");
    }

    private void viewDonorById() throws SQLException {
        System.out.print("Enter donor ID to view: ");
        int id = Integer.parseInt(scanner.nextLine());

        Donor donor = donorService.getDonorById(id);
        if (donor != null) {
            System.out.println(donor);
        } else {
            System.out.println("Donor not found with ID: " + id);
        }
    }

    // Blood Inventory Management
    private void manageBloodInventory() throws SQLException {
        while (true) {
            showBloodInventoryMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addBloodInventory();
                    break;
                case 2:
                    viewAllBloodInventories();
                    break;
                case 3:
                    updateBloodInventory();
                    break;
                case 4:
                    deleteBloodInventory();
                    break;
                case 5:
                    viewBloodInventoryById();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void showBloodInventoryMenu() {
        System.out.println("\nBlood Inventory Management");
        System.out.println("1. Add Blood Inventory");
        System.out.println("2. View All Blood Inventories");
        System.out.println("3. Update Blood Inventory");
        System.out.println("4. Delete Blood Inventory");
        System.out.println("5. View Blood Inventory by ID");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private void addBloodInventory() throws SQLException {
        System.out.print("Enter blood group: ");
        String bloodGroup = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        BloodInventory bloodInventory = new BloodInventory();
        bloodInventory.setBloodGroup(bloodGroup);
        bloodInventory.setQuantity(quantity);

        bloodInventoryService.addBloodInventory(bloodInventory);
        System.out.println("Blood Inventory added successfully!");
    }

    private void viewAllBloodInventories() throws SQLException {
        List<BloodInventory> bloodInventories = bloodInventoryService.getAllBloodInventories();
        System.out.println("\nBlood Inventory List:");
        for (BloodInventory bloodInventory : bloodInventories) {
            System.out.println(bloodInventory);
        }
    }

    private void updateBloodInventory() throws SQLException {
        System.out.print("Enter inventory ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter new blood group: ");
        String bloodGroup = scanner.nextLine();
        System.out.print("Enter new quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        BloodInventory bloodInventory = new BloodInventory();
        bloodInventory.setId(id);
        bloodInventory.setBloodGroup(bloodGroup);
        bloodInventory.setQuantity(quantity);

        bloodInventoryService.updateBloodInventory(bloodInventory);
        System.out.println("Blood Inventory updated successfully!");
    }

    private void deleteBloodInventory() throws SQLException {
        System.out.print("Enter inventory ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        bloodInventoryService.deleteBloodInventory(id);
        System.out.println("Blood Inventory deleted successfully!");
    }

    private void viewBloodInventoryById() throws SQLException {
        System.out.print("Enter inventory ID to view: ");
        int id = Integer.parseInt(scanner.nextLine());

        BloodInventory bloodInventory = bloodInventoryService.getBloodInventoryById(id);
        if (bloodInventory != null) {
            System.out.println(bloodInventory);
        } else {
            System.out.println("Blood Inventory not found with ID: " + id);
        }
    }

    // Blood Request Management
    private void manageBloodRequests() throws SQLException {
        while (true) {
            showBloodRequestMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addBloodRequest();
                    break;
                case 2:
                    viewAllBloodRequests();
                    break;
                case 3:
                    updateBloodRequest();
                    break;
                case 4:
                    deleteBloodRequest();
                    break;
                case 5:
                    viewBloodRequestById();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void showBloodRequestMenu() {
        System.out.println("\nBlood Request Management");
        System.out.println("1. Add Blood Request");
        System.out.println("2. View All Blood Requests");
        System.out.println("3. Update Blood Request");
        System.out.println("4. Delete Blood Request");
        System.out.println("5. View Blood Request by ID");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private void addBloodRequest() throws SQLException {
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter blood group: ");
        String bloodGroup = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter status: ");
        String status = scanner.nextLine();

        BloodRequest bloodRequest = new BloodRequest();
        bloodRequest.setPatientName(patientName);
        bloodRequest.setBloodGroup(bloodGroup);
        bloodRequest.setQuantity(quantity);
        bloodRequest.setStatus(status);

        bloodRequestService.addBloodRequest(bloodRequest);
        System.out.println("Blood Request added successfully!");
    }

    private void viewAllBloodRequests() throws SQLException {
        List<BloodRequest> bloodRequests = bloodRequestService.getAllBloodRequests();
        System.out.println("\nBlood Request List:");
        for (BloodRequest bloodRequest : bloodRequests) {
            System.out.println(bloodRequest);
        }
    }

    private void updateBloodRequest() throws SQLException {
        System.out.print("Enter request ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter new patient name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter new blood group: ");
        String bloodGroup = scanner.nextLine();
        System.out.print("Enter new quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new status: ");
        String status = scanner.nextLine();

        BloodRequest bloodRequest = new BloodRequest();
        bloodRequest.setId(id);
        bloodRequest.setPatientName(patientName);
        bloodRequest.setBloodGroup(bloodGroup);
        bloodRequest.setQuantity(quantity);
        bloodRequest.setStatus(status);

        bloodRequestService.updateBloodRequest(bloodRequest);
        System.out.println("Blood Request updated successfully!");
    }

    private void deleteBloodRequest() throws SQLException {
        System.out.print("Enter request ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        bloodRequestService.deleteBloodRequest(id);
        System.out.println("Blood Request deleted successfully!");
    }

    private void viewBloodRequestById() throws SQLException {
        System.out.print("Enter request ID to view: ");
        int id = Integer.parseInt(scanner.nextLine());

        BloodRequest bloodRequest = bloodRequestService.getBloodRequestById(id);
        if (bloodRequest != null) {
            System.out.println(bloodRequest);
        } else {
            System.out.println("Blood Request not found with ID: " + id);
        }
    }

    // Staff Management
    private void manageStaff() throws SQLException {
        while (true) {
            showStaffMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    viewAllStaff();
                    break;
                case 3:
                    updateStaff();
                    break;
                case 4:
                    deleteStaff();
                    break;
                case 5:
                    viewStaffById();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void showStaffMenu() {
        System.out.println("\nStaff Management");
        System.out.println("1. Add Staff");
        System.out.println("2. View All Staff");
        System.out.println("3. Update Staff");
        System.out.println("4. Delete Staff");
        System.out.println("5. View Staff by ID");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private void addStaff() throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter role: ");
        String role = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Staff staff = new Staff();
        staff.setName(name);
        staff.setRole(role);
        staff.setContactNumber(contactNumber);
        staff.setEmail(email);

        staffService.addStaff(staff);
        System.out.println("Staff added successfully!");
    }

    private void viewAllStaff() throws SQLException {
        List<Staff> staffList = staffService.getAllStaff();
        System.out.println("\nStaff List:");
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }

    private void updateStaff() throws SQLException {
        System.out.print("Enter staff ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new role: ");
        String role = scanner.nextLine();
        System.out.print("Enter new contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        Staff staff = new Staff();
        staff.setId(id);
        staff.setName(name);
        staff.setRole(role);
        staff.setContactNumber(contactNumber);
        staff.setEmail(email);

        staffService.updateStaff(staff);
        System.out.println("Staff updated successfully!");
    }

    private void deleteStaff() throws SQLException {
        System.out.print("Enter staff ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        staffService.deleteStaff(id);
        System.out.println("Staff deleted successfully!");
    }

    private void viewStaffById() throws SQLException {
        System.out.print("Enter staff ID to view: ");
        int id = Integer.parseInt(scanner.nextLine());

        Staff staff = staffService.getStaffById(id);
        if (staff != null) {
            System.out.println(staff);
        } else {
            System.out.println("Staff not found with ID: " + id);
        }
    }
}
