package fr.dauphine.javaavance.td5;

public class EE06 {

    public EE06(int value) throws ErrConst {
        if (value < 0) {
            throw new ErrConst(value);
        }
    }

    private static class ErrConst extends ErrNat {
        public ErrConst(int value) {
            super("The value " + value + " is negative");
        }
    }

    public static int sum(int a, int b) throws ErrSom {
        if (a + b < 0) {
            throw new ErrSom(a, b);
        }
        return a + b;
    }

    private static class ErrSom extends ErrNat {
        public ErrSom(int a, int b) {
            super("The sum of " + a + " and " + b + " is negative");
        }
    }

    public static int difference(int a, int b) throws ErrDiff {
        if (a - b < 0) {
            throw new ErrDiff(a, b);
        }
        return a - b;
    }

    private static class ErrDiff extends ErrNat {
        public ErrDiff(int a, int b) {
            super("The difference of " + a + " and " + b + " is negative");
        }
    }

    public static int product(int a, int b) throws ErrProd {
        if (a * b < 0) {
            throw new ErrProd(a, b);
        }
        return a * b;
    }

    private static class ErrProd extends ErrNat {
        public ErrProd(int a, int b) {
            super("The product of " + a + " and " + b + " is negative");
        }
    }

    private static class ErrNat extends Throwable {
        public ErrNat(String message) {
            super(message);
        }
    }

    private static int getN(int value) throws ErrNat {
        if (value < 0) {
            throw new ErrNat("The value " + value + " is negative");
        }
        return value;
    }

    public static void main(String[] args) {
        try {
            System.out.println(getN(-1));
        } catch (ErrNat errNat) {
            System.out.println(errNat.getMessage());
        }
        try {
            System.out.println(sum(-1, 1));
        } catch (ErrSom errSom) {
            System.out.println(errSom.getMessage());
        }
        try {
            System.out.println(difference(1, -1));
        } catch (ErrDiff errDiff) {
            System.out.println(errDiff.getMessage());
        }
        try {
            System.out.println(product(1, -1));
        } catch (ErrProd errProd) {
            System.out.println(errProd.getMessage());
        }
    }


}
