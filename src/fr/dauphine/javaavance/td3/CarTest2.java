package fr.dauphine.javaavance.td3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CarTest2 {

    @Test
    public void testEquals() {
        Car car1 = new Car("BMW", "42abc75", 15000);
        Car car2 = new Car("BMW", "42abc75", 15000);
        assertTrue(car1.equals(car2));
    }

    @Test
    public void testEquals2() {
        Car c = new Car("BMW", "42abc75", 15000);
        assertFalse(c.equals(new String()));
    }

    @Test
    public void testContains1() {
        Car car1 = new Car("BMW", "42abc75", 15000);
        Car car2 = new Car("BMW", "42abc75", 15000);
        ArrayList<Car> list = new ArrayList<>();
        list.add(car1);
        assertTrue(list.contains(car2));
    }

    @Test
    public void testContains2() {
        Car car1 = new Car("BMW", "42abc75", 15000);
        Car car2 = new Car("BMW", "42abc75", 15000);
        HashSet<Car> set = new HashSet<>();
        set.add(car1);
        assertTrue(set.contains(car2));
    }

    @Test
    public void testNotContains1a() {
        Car car1 = new Car("BMW", "42abc75", 15000);
        Car car2 = new Car("BMW", "42abc75", 25000);
        ArrayList<Car> list = new ArrayList<>();
        list.add(car1);
        assertTrue(!list.contains(car2));
    }

    @Test
    public void testNotContains1b() {
        Car car1 = new Car("BMW", "42abc75", 15000);
        Car car2 = new Car("bmw", "42abc75", 15000);
        ArrayList<Car> list = new ArrayList<>();
        list.add(car1);
        assertTrue(!list.contains(car2));
    }

    @Test
    public void testNotContains2a() {
        Car car1 = new Car("BMW", "42abc75", 15000);
        Car car2 = new Car("BMW", "42abc75", 25000);
        HashSet<Car> set = new HashSet<>();
        set.add(car1);
        assertTrue(!set.contains(car2));
    }

    @Test
    public void testNotContains2b() {
        Car car1 = new Car("BMW", "42abc75", 15000);
        Car car2 = new Car("bmw", "42abc75", 15000);
        HashSet<Car> set = new HashSet<>();
        set.add(car1);
        assertTrue(!set.contains(car2));
    }
}
