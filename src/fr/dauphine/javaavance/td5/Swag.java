package fr.dauphine.javaavance.td5;

import java.util.EnumSet;
import java.util.LinkedHashSet;

public class Swag {

    private static String cross(String txt) {
        String result = "";
        for (int i = 0; i < txt.length(); i++) {
            result += txt.charAt(i);
            if (i != txt.length() - 1) {
                result += "+";
            }
        }
        return result;
    }

    private static String kikoo(String txt) {
        String result = "";
        for (int i = 0; i < txt.length(); i++) {
            if (i % 2 == 0) {
                result += Character.toUpperCase(txt.charAt(i));
            } else {
                result += Character.toLowerCase(txt.charAt(i));
            }
        }
        return result;
    }

    public static String swag(String s, EnumSet<STYLE> style) {
        String result = s;
        if (style.contains(STYLE.CROSS)) {
            result = cross(result);
        }
        if (style.contains(STYLE.KIKOU)) {
            result = kikoo(result);
        }
        return result;
    }

    public static String swag(String s, LinkedHashSet<STYLE> style) {
        String result = "";
        if (style.contains(STYLE.CROSS) && style.contains(STYLE.KIKOU)) {
            if (style.stream().findFirst().get() == STYLE.CROSS) {
                result = kikoo(cross(s));
            } else {
                result = cross(kikoo(s));
            }
        } else {
            result = swag(s, EnumSet.copyOf(style));
        }
        return result;
    }

}
