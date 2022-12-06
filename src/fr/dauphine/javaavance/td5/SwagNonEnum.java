package fr.dauphine.javaavance.td5;

public class SwagNonEnum {
    public static final int CROSS = 1;
    public static final int KIKOO = 2;

    public static String swag(String txt, int style) {
        switch (style) {
            case CROSS:
                return cross(txt);
            case KIKOO:
                return kikoo(txt);
            case CROSS | KIKOO:
                return cross(kikoo(txt));

            default:
                return txt;
        }


    }

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


    public static void main(String[] args) {
        System.out.println(swag("miage", CROSS));
        System.out.println(swag("miage", KIKOO));
        System.out.println(swag("miage", CROSS | KIKOO));
    }

}
