package model;

public class BloodRequest {
    private int id;
    private String patientName;
    private String bloodGroup;
    private int quantity;
    private String status;

    public BloodRequest(int id, String patientName, String bloodGroup, int quantity, String status) {
        this.id = id;
        this.patientName = patientName;
        this.bloodGroup = bloodGroup;
        this.quantity = quantity;
        this.status = status;
    }

    public BloodRequest() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BloodRequest{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }
}
