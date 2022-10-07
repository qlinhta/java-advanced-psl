package fr.dauphine.javaavance.td3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class BikeTest {

    @Test
    public void sameValue() {
        Bike bike1 = new Bike("Topbike", null);
        Bike bike2 = new Bike("Topbike", null);
        assertEquals(bike1.getValue(), bike2.getValue());
    }

    @Test
    public void sameValue2() {
        Bike bike1 = new Bike("Topbike", new Discount(100));
        Bike bike2 = new Bike("Topbike", null);
        assertEquals(bike1.getValue(), bike2.getValue());
    }

    @Test
    public void testEquals() {
        Bike bike1 = new Bike("Cannondale");
        assertEquals(bike1, new Bike("Cannondale"));
    }

    @Test
    public void testEquals2() {
        Bike bike1 = new Bike("Cannondale");
        assertFalse(bike1.equals(new Car("a", "b", 1)));
    }

    @Test
    public void testEquals3() {
        Vehicule bike1 = new Bike("Cannondale");
        assertFalse(bike1.equals(new Car("a", "b", 1)));
    }

    @Test
    public void testEquals4() {
        Vehicule bike1 = new Bike("Cannondale");
        assertEquals(bike1, new Bike("Cannondale"));
    }

}
