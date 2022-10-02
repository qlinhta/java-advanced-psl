package fr.dauphine.javaavance.td3;

public class Bike {

    /*
    Exercice 3. Start here
     */

    /*
    1. Create a class Bike with the following attributes: Brand
    2. We consider that the value of a bicycle is unique and fixed (constant) at 100 euros. Make the necessary changes.
     */

    private String brand;
    private static final int PRICE = 100;

    // Constructor
    public Bike(String brand) {
        this.brand = brand;
    }

    /*
    3. What changes need to be made to be able to add bikes to the garage? Do it !
    >> Solution 1: Add a method addBike() to the Garage class, which takes a Bike object as a parameter.
    Then add the bike to the list of bikes in the garage. This solution is not very elegant because it is not
    the responsibility of the Garage class to add a bike to the list of bikes.
    >> Solution 2: Add a method addBike() to the Bike class, which takes a Garage as a parameter and adds the bike to
    the garage. Make the necessary changes to the Garage class (add a list of bikes). This solution is more elegant.
    I chose this solution.
     */

    public void addBike(Garage garage) {
        garage.addBike(this);
    }

    public Object getBrand() {
        return brand;
    }

    public int getPrice() {
        return PRICE;
    }
}
