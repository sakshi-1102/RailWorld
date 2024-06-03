package model;

public class Donor {
    private int id;
    private String name;
    private String bloodGroup;
    private String contactNumber;
    private String email;

    public Donor() {}

    public Donor(int id, String name, String bloodGroup, String contactNumber, String email) {
        this.id = id;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
