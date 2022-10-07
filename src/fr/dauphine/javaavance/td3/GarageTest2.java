package fr.dauphine.javaavance.td3;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class GarageTest2 {
    //exo2
    @Test(expected = IllegalStateException.class)
    public void garageRemoveNotExist() {
        Garage garage = new Garage();
        garage.remove(new Car("BMW", "42abc75", 20000));
    }

    @Test
    public void garageAddRemove() {
        Garage garage = new Garage();
        garage.add(new Car("Ford", "42abc75", 25000));
        garage.remove(new Car("Ford", "42abc75", 25000));
        assertNull(garage.firstCarByBrand("Ford"));
    }

    @Test(expected = NullPointerException.class)
    public void findACarByModelNull() {
        Garage garage = new Garage();
        garage.firstCarByBrand(null);
    }

}
