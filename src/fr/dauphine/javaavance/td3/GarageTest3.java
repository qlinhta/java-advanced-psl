package fr.dauphine.javaavance.td3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GarageTest3 {

    @Test
    public void testProtectionism() {
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

    @Test
    public void testDiscount() {
        Garage garage = new Garage(10);
        Car car1 = new Car("Audi", 10000);
        Car car2 = new Car("BMW", 9000);
        Car car3 = new Car("BMW", 9000);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.setAgeLevel(2);
        Discount discount = new Discount(1000);
        car1.setDiscount(discount);
        assertEquals(22000, garage.calculateValue());
    }


}
