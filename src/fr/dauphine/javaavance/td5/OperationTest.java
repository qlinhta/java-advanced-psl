package fr.dauphine.javaavance.td5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    public void testOperationPlus() {
        assertEquals("+", Operation.PLUS.toString());
    }

    @Test
    public void testOperationMinus() {
        assertEquals("-", Operation.MINUS.toString());
    }

    @Test
    public void testComputePlus() {
        assertEquals(5, Operation.PLUS.compute(2, 3), 0.1);
    }

    @Test
    public void testComputeCombo() {
        assertEquals(9, Operation.PLUS.compute(Operation.MULT.compute(2, 3), 3), 0.1);
    }

}