package fr.dauphine.javaavance.td3;

import java.util.Objects;

public class Garage {

    /*
    6. Write a class Garage that to store instances of Car. Add a method in Garage to add a car in the garage.
        Make it impossible to add a null car to the garage using Objects.requireNonNull().
     */

    private Car[] cars;
    private int size;

    public Garage(int capacity, int id) {
        cars = new Car[capacity];
        this.id = id;
        size = 0;
    }

    // Method that adds a car to the garage, throws an exception if the car is null
    public void addCar(Car car) {
        Objects.requireNonNull(car, "car");
        cars[size] = car;
        size++;
    }


    /*
    7. We want each garage to have a unique identifier specific to each garage (also make a getId() method).
    For the exercise, we use the number of created instances of the Garage class. (think of static fields).
     */

    private static int idCounter = 0;
    private final int id;

    public Garage() {
        id = idCounter;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    /*
    8. Write a toString() method to display a garage properly using a StringBuilder.
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Garage ").append(id).append(":").append(System.lineSeparator());
        for (int i = 0; i < size; i++) {
            sb.append(cars[i].getString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    /*
    9. Write a  permanent method to calculate the value of garage (contain total of the value of all car in garage).

    >>
        public long calculateValue() {
        long value = 0;
        for (int i = 0; i < size; i++) {
            value += cars[i].getValue();
        }
        return value;
    }

     */




    /*
    10. Write a firstCarByBrand method that takes a brand as a parameter and returns the first car of this brand.
    What should we do if there is no car of this brand?
    >>We can return null or throw an exception. I chose to throw an exception.
     */

    public Car firstCarByBrand(String brand) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getBrand().equals(brand)) {
                return cars[i];
            }
        }
        throw new IllegalArgumentException("No car of this brand");
    }

    /*
    11. Cars can now have an age level. 0 is not dilapidated, then for each level, the value of the car decreases by
    1000th. For example, a car worth 10,000e with an age level of 2 is now worth 8,000. Add a field corresponding to
    this age level and modify the implementation accordingly. The level of obsolescence may or may not be specified
    during construction (builder surcharge).
     */

    // I added a constructor with ageLevel parameter and a setter for ageLevel.
    // I modified the calculateValue() method to take ageLevel into account.

    private int ageLevel;

    public Garage(int capacity, int id, int ageLevel) {
        cars = new Car[capacity];
        this.id = id;
        size = 0;
        this.ageLevel = ageLevel;
    }

    public void setAgeLevel(int ageLevel) {
        this.ageLevel = ageLevel;
    }

    public long calculateValue() {
        long value = 0;
        for (int i = 0; i < size; i++) {
            value += cars[i].getValue() - ageLevel * 1000L;
        }
        return value;
    }

    /*
    12. Write JUNIT tests for the class Garage and Car.
    >> See src/fr/dauphine/javaavance/td3/GarageTest.java and src/fr/dauphine/javaavance/td3/CarTest.java
     */


}
