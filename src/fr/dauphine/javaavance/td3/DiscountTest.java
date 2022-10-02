package fr.dauphine.javaavance.td3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {

    /*
    JUNIT TEST for Discount class
     */

    @Test
    public void testDiscount() {
        Discount discount = new Discount(1000);
        assertEquals(1000, discount.getValue());
    }

    @Test
    public void testDiscount2() {
        Discount discount = new Discount(1000);
        discount.setValue(2000);
        assertEquals(2000, discount.getValue());
    }

    @Test
    public void testDiscount3() {
        Discount discount = new Discount(1000);
        discount.setValue(2000);
        discount.setValue(3000);
        assertEquals(3000, discount.getValue());
    }
}

