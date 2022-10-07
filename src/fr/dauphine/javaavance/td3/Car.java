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

    // Constructor for the 2nd and 3rd question
    /*
    public Car(String brand, long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        this.brand = brand;
        this.value = value;
    }
     */

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
    // toString() method for the 5th question
    /*
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", value=" + value +
                '}';
    }
     */

    /*
    11. Cars can now have an age level. 0 is not old, then for each level, the value of the car decreases by 1000e.
    For instance, a car worth 10,000e with wear level 2 is now worth 8000. Add a field corresponding to this age level
    and modify implementation accordingly. The level of age can be specified or not at construction (constructor overload).
     */

    private int wearLevel;

    // Constructor 1 for the 11th question

    public Car(String brand, long value, int wearLevel) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        this.brand = brand;
        this.value = value;
        this.wearLevel = wearLevel;
    }

    // Constructor 2 for the 11th question

    public Car(String brand, long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        this.brand = brand;
        this.value = value;
        this.wearLevel = 0;
    }

    // Getters for the 11th question

    public int getWearLevel() {
        return wearLevel;
    }

    // Setters for the 11th question

    public void setWearLevel(int wearLevel) {
        this.wearLevel = wearLevel;
    }

    // toString() method for the 11th question

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", value=" + value +
                ", wearLevel=" + wearLevel +
                '}';
    }

}
