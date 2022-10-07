package fr.dauphine.javaavance.td3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void testGetBrand() {
        Car car  = new Car("BMW", "55abc75", 20000);
        assertEquals("BMW", car.getBrand());
    }

    @Test
    public void testGetValue() {
        Car car  = new Car("Peugeot", "55abc75", 12000);
        assertEquals(12000, car.getValue());
    }

    @Test
    public void testVetuste() {
        Car car  = new Car("Peugeot", "55abc75", 12000, 2);
        assertEquals(10000, car.getValue());
    }

    @Test
    public void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new Car("Truc", "55abc75", -1));
    }

    @Test
    public void testTooOld() {
        assertThrows(IllegalArgumentException.class, () -> new Car("Peugeot", "55abc75", 12000, 200));
    }

    @Test
    public void newCarNoBrand() {
        assertThrows(NullPointerException.class, () -> new Car(null, "55abc75", 20000));
    }

    @Test
    public void newCarNoPlate() {
        assertThrows(NullPointerException.class, () -> new Car("bla", null, 20000));
    }
    @Test
    public void newCarNoBrand2() {
        assertThrows(NullPointerException.class, () -> new Car(null, "55abc75", 20000, 2));
    }

    @Test
    public void newCarNoPlate2() {
        assertThrows(NullPointerException.class, () -> new Car("BM", null, 20000, 2));

    }
}
