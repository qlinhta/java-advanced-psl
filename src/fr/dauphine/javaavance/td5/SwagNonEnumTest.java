package fr.dauphine.javaavance.td5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwagNonEnumTest {

    @Test
    public void testKikouInt() {
        assertEquals("MiAgE", SwagNonEnum.swag("miage", SwagNonEnum.KIKOO));
    }

    @Test
    public void testComboInt() {
        assertEquals("M+i+A+g+E", SwagNonEnum.swag("miage", SwagNonEnum.CROSS | SwagNonEnum.KIKOO));
    }

}