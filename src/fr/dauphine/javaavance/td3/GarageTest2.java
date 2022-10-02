package fr.dauphine.javaavance.td3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GarageTest2 {

    // JUnit 5 test for Garage.java
    // Compare this snippet from src/fr/dauphine/javaavance/td3/Garage.java:

    @Test
    public void testRemoveCar() {
        Garage garage = new Garage(10);
        Car car1 = new Car("Audi", 10000);
        Car car2 = new Car("BMW", 9000);
        Car car3 = new Car("BMW", 9000);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.remove(car2);
        assertEquals(2, garage.getSize());
    }

}
