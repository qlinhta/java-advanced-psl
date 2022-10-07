package fr.dauphine.javaavance.td3;

public class Garage {

    /*
    6. Write a class Garage to store instances of Car (think about the appropriate data structure for this).
    Add a method in Garage to add a car to the garage. Make it impossible to add a null car in the garage using Objects.requireNonNull().
     */

    private static int id = 0;
    private int idGarage;
    private Car[] cars;
    private Bike[] bikes;
    private int nbCars;
    private int nbBike;

    public Garage() {
        this.idGarage = id++;
        this.cars = new Car[10];
        this.nbCars = 0;
    }


    // Can't add a null car in the garage
    public void add(Car car) {
        if (car == null) {
            throw new NullPointerException("Can't add a null car in the garage");
        }
        if (nbCars == cars.length) {
            Car[] newCars = new Car[cars.length * 2];
            System.arraycopy(cars, 0, newCars, 0, cars.length);
            cars = newCars;
        }
        cars[nbCars++] = car;
    }



    /*
    7. We want each garage to have a unique identifier specific to each garage (do also a getId() method).
    For the exercise, we use the number of instances created from the Garage class. (think of static fields).
     */

    public int getId() {
        return idGarage;
    }

    /*
    8. Write a toString() method to display a garage properly using of a StringBuilder.
     */



    /*
    9. Add a method to calculate the total value of a garage (sum of the value of the cars it contains).
     */

    public long value() {
        long value = 0;
        for (int i = 0; i < nbCars; i++) {
            value += cars[i].getValue();
        }
        return value;
    }

    /*
    10. Write a method firstCarByBrand which takes a brand as parameter and returns the first car of this brand.
    What should we do if there is no car of this brand?
     */

    /**
     * Returns the first car of the brand given in parameter
     *
     * @return the first car of the brand given in parameter
     * throw NullPointerException if brand is null
     */

    public Car firstCarByBrand(String brand) {
        if (brand == null) {
            throw new NullPointerException("Brand can't be null");
        }
        for (int i = 0; i < nbCars; i++) {
            if (cars[i].getBrand().equals(brand)) {
                return cars[i];
            }
        }
        return null;
    }

    public long getValue() {
        long value = 0;
        for (int i = 0; i < nbCars; i++) {
            value += cars[i].getValue();
        }
        return value;
    }

    /*
    4. Write a remove method in Garage that takes a car as an argument and which allows to remove a car from the garage
     */

    /**
     * Remove a car from the garage
     *
     * @param car
     * @return true if the car was removed
     * throw IllegalStateExeption if the car is not in the garage
     * throw NullPointerException if the car is null
     */

    public boolean remove(Car car) {
        if (car == null) {
            throw new NullPointerException("Can't remove a null car from the garage");
        }
        for (int i = 0; i < nbCars; i++) {
            if (cars[i].equals(car)) {
                cars[i] = cars[nbCars - 1];
                cars[nbCars - 1] = null;
                nbCars--;
                return true;
            }
        }
        throw new IllegalStateException("The car is not in the garage");
    }
}
