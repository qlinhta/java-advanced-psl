package fr.dauphine.javaavance.td3;

public class Discount {

    /*
    4. The garage now wants to be able to do sales for a while. Create a Discount class with a value field.
    This value must replace the original price of the vehicle if the vehicle is on sale
    (Discount field to null or not).
     */

    private int value; // Value of the discount, null if no discount
    // Constructor
    public Discount(int value) {
        this.value = value;
    }

    // Getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /*
    To continue:
    Add a method to the Garage class which allows to add a discount to a vehicle.
    This method must take a vehicle and a discount as arguments.
    The vehicle must be in the garage. If the vehicle is not in the garage, an exception must be thrown.
    If the vehicle is in the garage, the discount must be added to the vehicle.
    The discount must be added to the vehicle, not to the garage. The vehicle must have a discount field.
     */

}
