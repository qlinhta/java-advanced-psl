package fr.dauphine.javaavance.td3;

public class Car {

    /*
    1. Write a Car class representing a car, with two final private fields brand (character string) and value (long).
     */

    private final String brand;
    private final long value;

    /*
    2. Write the constructor taking the values of the fields as parameters.
    3. Make it impossible to create a car with a negative value.
     */

    public Car(String brand, long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        this.brand = brand;
        this.value = value;
    }

    /*
    4. Write get methods for both fields.
     */

    public String getBrand() {
        return brand;
    }

    public long getValue() {
        return value;
    }

    /*
    5. Write a toString() method to display a car and its characteristics
     */

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", value=" + value +
                '}';
    }



}
