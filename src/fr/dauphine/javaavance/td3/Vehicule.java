package fr.dauphine.javaavance.td3;

public class Vehicule {
    private final String brand;
    private final long value;
    Discount discount;

    public Vehicule(String brand, long value) {
        this.brand = brand;
        this.value = value;
    }

    public Vehicule(String brand, Discount discount) {
        this.brand = brand;
        this.value = discount.getValue();
    }

    public Vehicule() {
        this.brand = null;
        this.value = 0;
    }


    public String getBrand() {
        return brand;
    }

    // Update value after discount also
    public long getValue() {
        if (discount != null) {
            return discount.getValue();
        }
        return value;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }


    public <T> Comparable<T> getName() {
        return (Comparable<T>) brand;
    }
}
