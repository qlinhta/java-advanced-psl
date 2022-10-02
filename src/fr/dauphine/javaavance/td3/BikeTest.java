package fr.dauphine.javaavance.td3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeTest {

    // This is Unit Test for the class Bike

    @Test
    public void testAddBike() {
        Garage garage = new Garage(10);
        Bike bike = new Bike("Audi");
        bike.addBike(garage);
        assertEquals(1, garage.getSizeBikes()); // Test if the bike is added to the garage, the size of the garage must be 1
    }

    @Test
    public void testGetBrand() {
        Bike bike = new Bike("Audi");
        assertEquals("Audi", bike.getBrand()); // Test if the brand of the bike is "Audi"
    }

    @Test
    public void testBikePrice() {
        Bike bike = new Bike("Audi");
        assertEquals(100, bike.getPrice()); // Test if the price of the bike is 100
    }
}
