package fr.dauphine.javaavance.td3;

import java.util.Objects;

public class Discount {

    /*
    4. The garage now wants to be able to do sales for a while. Create a Discount class with a value field.
    This value must replace the original price of the vehicle if the vehicle is on sale (Discount field to null or not).
     */

    private final long value; // The value of vehicle when it is on sale

    public Discount(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("The value of vehicle when it is on sale must be positive");
        }
        this.value = value;
    }


    public long getValue() {
        return value;
    }

    // Method equals() update for discount comparison

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return value == discount.value;
    }

    // Method hashCode() update for discount comparison

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
