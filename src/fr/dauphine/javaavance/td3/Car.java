package fr.dauphine.javaavance.td3;

public class Car {

    /*
    1. Write a class Car present a car with two private, final champs: brand (String) and value (long)
     */

    private final String brand;
    private final long value;

    /*
    2. Write a constructor that takes two parameters and initializes the two fields
    3. Make it impossible to create a car with a negative value.
     */

    public Car(String brand, long value) {
        this.brand = brand;
        if (value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        this.value = value;
    }

    /*
    4. Write a getter for each field
     */

    public String getBrand() {
        return brand;
    }

    public long getValue() {
        return value;
    }

    /*
    5. Write a method getString() that returns the information of the car in the form of a string
     */

    public String getString() {
        return "Brand: " + brand + ", Value: " + value;
    }

}
