package fr.dauphine.javaavance.td3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GarageTest {

    /*
    JUNIT TEST for Garage class
     */

    @Test
    public void testAddCar() {
        Garage garage = new Garage(10);
        Car car = new Car("Audi", 10000);
        garage.addCar(car);
        assertEquals(1, garage.getSize());
    }

    @Test
    public void testCalculateValue() {
        Garage garage = new Garage(10);
        Car car1 = new Car("Audi", 10000);
        Car car2 = new Car("BMW", 9000);
        Car car3 = new Car("BMW", 9000);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        assertEquals(28000, garage.calculateValue());
    }

    @Test
    public void testCalculateValueWithAgeLevel() {
        Garage garage = new Garage(10);
        Car car1 = new Car("Audi", 10000);
        Car car2 = new Car("BMW", 9000);
        Car car3 = new Car("BMW", 9000);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.setAgeLevel(2);
        assertEquals(22000, garage.calculateValue());
    }
}
