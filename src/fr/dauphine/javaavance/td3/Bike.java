package fr.dauphine.javaavance.td3;

import java.util.Objects;

public class Bike extends Vehicule {

    /*
    1. Write a class Bike containing only a field concerning the brand.
     */

    private final String brand;

    /*
    2. We consider that the value of a bicycle is unique and fixed (constant) at 100 euros. Make the necessary changes.
     */

    private static final long VALUE = 100;

    public Bike(String brand, Object o) {
        super(brand, VALUE);
        this.brand = brand;
    }

    public Bike(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    // Update value after discount also

    @Override
    public long getValue() {
        if (discount != null) {
            return discount.getValue();
        }
        return VALUE;
    }

    // Method equals() update for bikes comparison

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return brand.equals(bike.brand);
    }

    // Method hashCode() update for bikes comparison

    @Override
    public int hashCode() {
        return Objects.hash(brand);
    }

    // toString() method update

    @Override
    public String toString() {
        return "Bike{" +
                "brand='" + brand + '\'' +
                ", value=" + VALUE +
                '}';
    }

    /*
    3. What changes need to be made in order to be able to add bikes to the garage ? Do it !
    >> Create a new class Vehicule and make Car and Bike extend it, then change the type of the array cars in Garage to Vehicule.
    See changes in Garage.java
     */


}
