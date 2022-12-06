package fr.dauphine.javaavance.exception;

/*
[Using exceptions in constructors]
Toutou is a class with two private properties String name and int numberChips.
Write a public Toutou (String n, int np) constructor that propagates exceptions from type IllegalArgumentException
when name n is null or when number of bullets np is negative.
Use this constructor in a main method to monitor calls new Toutou ("milou", 4) and new Toutou ("medor", -11) and
display any errors when executing the constructors.
 */
public class Toutou {
    private final String name;
    private final int numberChips;

    public Toutou(String n, int np) throws IllegalArgumentException {
        if (n == null || np < 0) {
            throw new IllegalArgumentException("Name n is null or when number of bullets np is negative");
        }
        this.name = n;
        this.numberChips = np;
    }

    public static void main(String[] args) {
        try {
            Toutou t1 = new Toutou("milou", -1);
            System.out.println(t1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
