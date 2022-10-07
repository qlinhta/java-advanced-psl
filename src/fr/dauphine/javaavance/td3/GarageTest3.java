package fr.dauphine.javaavance.td3;

import org.junit.Test;

import static org.junit.Assert.*;

public class GarageTest3 {

    @Test(expected = IllegalStateException.class)
    public void carRentalCarAndCamel2() {
        NewGarageVehicle garage = new NewGarageVehicle();
        garage.remove(new Bike("Cannondale", null));
    }

    @Test
    public void firstCarByBrand() {
        Vehicule v1 = new Car("BMW", "42abc75", 15000, 0);    //car 15000e without discount
        Vehicule v2 = new Bike("Renault", null);
        Vehicule v3 = new Bike("Renault", null);
        NewGarageVehicle garage = new NewGarageVehicle();
        garage.add(v1);
        garage.add(v2);
        garage.add(v3);
        assertSame(v1, garage.firstCarByBrand("BMW"));
        assertSame(v2, garage.firstCarByBrand("Renault"));
    }

    @Test
    public void getValue() {
        Vehicule v1 = new Car("BMW", "42abc75", 15000, 0);
        Bike v2 = new Bike("Renault", null);
        NewGarageVehicle garage = new NewGarageVehicle();
        garage.add(v1);
        garage.add(v2);
        assertEquals(v1.getValue() + v2.getValue(), garage.getValue());
    }

    @Test
    public void findACarByBrand() {
        NewGarageVehicle garage = new NewGarageVehicle();
        garage.add(new Car("Ford", "42abc75", 2020));
        garage.add(new Bike("Cannondale", null));
        assertEquals(new Car("Ford", "42abc75", 2020), garage.firstCarByBrand("Ford"));
    }


    @Test
    public void findACarByModel2() {
        NewGarageVehicle garage = new NewGarageVehicle();
        garage.add(new Car("Ford", "42abc75", 2020));
        garage.add(new Bike("Cannondale", null));

        assertNull(garage.firstCarByBrand("Renault"));
    }


    @Test
    public void protect() {
        NewGarageVehicle garage = new NewGarageVehicle();
        garage.add(new Car("Ford", "42abc75", 2020));
        garage.add(new Car("Ford", "412abc75", 2010));
        garage.add(new Car("Renault", "43abc75", 1910));
        garage.protectionism("Ford");
        assertEquals(garage.getValue(), 1910);
    }
}