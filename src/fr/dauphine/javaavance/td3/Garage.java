package fr.dauphine.javaavance.td3;

/*
6. Write a class Garage to store instances of Car (think about the appropriate data structure for this).
Add a method in Garage to add a car to the garage. Make it impossible to add a null car in the garage using Objects.requireNonNull().
 */

public class Garage {
    private Car[] cars;
    private int nbCars;
    private long totalValue;

    /* Constructor for the 6th question
    public Garage() {
        cars = new Car[10];
        nbCars = 0;
    }
    */

    public void add(Car car) {
        if (car == null) {
            throw new NullPointerException("Car must not be null");
        }
        this.cars[nbCars] = car;
        this.nbCars++;
    }

    /*
    7. We want each garage to have a unique identifier specific to each garage (do also a getId() method).
    For the exercise, we use the number of instances created from the Garage class. (think of static fields).
     */

    private static int nbGarages = 0;
    private int id;

    // Constructor for the 7th question, update by adding the id
    public Garage() {
        this.cars = new Car[10];
        this.nbCars = 0;
        this.id = nbGarages;
        nbGarages++;
    }

    public int getId() {
        return id;
    }

    /*
    8. Write a toString() method to display a garage properly using of a StringBuilder.
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Garage ").append(this.id).append(" : ").append(this.nbCars).append(" cars");
        for (int i = 0; i < this.nbCars; i++) {
            sb.append("Garage ").append(this.id).append(" : ").append(this.cars[i]);
        }
        return sb.toString();
    }

    /*
    9. Add a method to calculate the value of a garage (sum of the value of the cars it contains).
     */

    public long calculateValue() {
        long totalValue = 0;
        for (int i = 0; i < this.nbCars; i++) {
            totalValue += this.cars[i].getValue();
        }
        return totalValue;
    }


    /*
    10. Write a method firstCarByBrand which takes a brand as parameter and returns the first car of this brand.
    What should we do if there is no car of this brand?
     */

    public Object firstCarByBrand(String brand) {
        for (int i = 0; i < this.nbCars; i++) {
            if (this.cars[i].getBrand().equals(brand)) {
                return this.cars[i];
            }
        }
        return null;
    }


    public long getValue() {
        return totalValue;
    }
}
