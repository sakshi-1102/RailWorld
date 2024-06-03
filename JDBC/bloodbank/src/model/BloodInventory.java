package model;

public class BloodInventory {
    private int id;
    private String bloodGroup;
    private int quantity;

    public BloodInventory(int id, String bloodGroup, int quantity) {
        this.id = id;
        this.bloodGroup = bloodGroup;
        this.quantity = quantity;
    }

    public BloodInventory() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "BloodInventory{" +
                "id=" + id +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
