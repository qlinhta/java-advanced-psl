package fr.dauphine.javaavance.td3;

import org.junit.jupiter.api.Test;

public class CarTest2 {
    /*
    JUNIT TEST for Car class
     */

    @Test
    public void testEquals() {
        Car a = new Car("Audi", 10000);
        Car b = new Car("BMW", 9000);
        Car c = new Car("BMW", 9000);
        Car d = a;
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == d);
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(a.equals(d));
    }

}
