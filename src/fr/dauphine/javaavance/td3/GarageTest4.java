package fr.dauphine.javaavance.td3;

import org.junit.jupiter.api.Test;

public class GarageTest4 {

    // Unit test for the class Garage
    // Test if two garages are equal, create list of cars, add cars to the garage

    @Test
    public void testEqualsGarage() throws Exception {
        Garage garage1 = new Garage(2);
        Garage garage2 = new Garage(2);
        Car car1 = new Car("Peugeot", 100);
        Car car2 = new Car("Renault", 100);
        Car car3 = new Car("Peugeot", 100);
        Car car4 = new Car("Renault", 100);
        garage1.addCar(car1);
        garage1.addCar(car2);
        garage2.addCar(car3);
        garage2.addCar(car4);
        assert garage1.equals(garage2); // Failed expected
    }

    /*
    Why the test fails?
    >> Because the method equals() in the class Garage does not compare the list of bikes in the garage.
    And the list of bikes is an attribute of the class Garage. So we need to add this attribute to the method equals().
     */

    // To here, run test again

    @Test
    public void testEqualsGarage2() throws Exception {
        Garage garage1 = new Garage(2);
        Garage garage2 = new Garage(2);
        Car car1 = new Car("Peugeot", 100);
        Car car2 = new Car("Renault", 100);
        Car car3 = new Car("Peugeot", 100);
        Car car4 = new Car("Renault", 100);
        garage1.addCar(car1);
        garage1.addCar(car2);
        garage2.addCar(car3);
        garage2.addCar(car4);
        assert garage1.equalsGarages(garage2); // Passed
    }

}
