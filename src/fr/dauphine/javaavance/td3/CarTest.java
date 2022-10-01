package fr.dauphine.javaavance.td3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    /*
    JUNIT TEST for all methods of Car class
     */

    @Test
    public void testCar() {
        Car car = new Car("BMW", 100000);
        assertEquals("BMW", car.getBrand());
        assertEquals(100000, car.getValue());
    }

    @Test
    public void testCarException() {
        try {
            Car car = new Car("BMW", -100000);
        } catch (IllegalArgumentException e) {
            assertEquals("Value must be positive", e.getMessage());
        }
    }

    @Test
    public void testGetString() {
        Car car = new Car("BMW", 100000);
        assertEquals("Brand: BMW, Value: 100000", car.getString());
    }

    @Test
    public void testGetBrand() {
        Car car = new Car("BMW", 100000);
        assertEquals("BMW", car.getBrand());
    }

    @Test
    public void testGetValue() {
        Car car = new Car("BMW", 100000);
        assertEquals(100000, car.getValue());
    }

}
