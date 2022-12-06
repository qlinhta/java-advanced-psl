package fr.dauphine.javaavance.td5;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwagTest2 {

    @Test
    public void testCross() {
        assertEquals("m+i+a+g+e", Swag.swag("miage", EnumSet.of(STYLE.CROSS)));
    }

    @Test
    public void testKikoo() {
        assertEquals("MiAgE", Swag.swag("miage", EnumSet.of(STYLE.KIKOU)));
    }

    @Test
    public void testCombo() {
        LinkedHashSet<STYLE> hs = new LinkedHashSet<>();
        hs.add(STYLE.KIKOU);
        hs.add(STYLE.CROSS);
        assertEquals("M+i+A+g+E", Swag.swag("miage", hs));
    }

}