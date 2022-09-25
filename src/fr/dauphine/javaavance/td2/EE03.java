package fr.dauphine.javaavance.td2;

abstract class Expr {
    public abstract double eval();

    public abstract String toString();
}

class Value extends Expr {
    private double value;

    public Value(double value) {
        this.value = value;
    }

    public double eval() {
        return value;
    }

    public String toString() {
        return "" + value;
    }
}

class Add extends Expr {
    private double v1, v2;

    public Add(Value v1, Value v2) {
        this.v1 = v1.eval();
        this.v2 = v2.eval();
    }

    public double eval() {
        return v1 + v2;
    }

    public String toString() {
        return v1 + " + " + v2;
    }
}

class Mult extends Expr {
    private double v1, v2;

    public Mult(Value v1, Value v2) {
        this.v1 = v1.eval();
        this.v2 = v2.eval();
    }

    public double eval() {
        return v1 * v2;
    }

    public String toString() {
        return v1 + " * " + v2;
    }
}

class SquaredRoot extends Expr {
    private double v1;

    public SquaredRoot(Value v1) {
        this.v1 = v1.eval();
    }

    public double eval() {
        return Math.sqrt(v1);
    }

    public String toString() {
        return "\u221a" + v1;
    }
}

public class EE03 {
    public static void main(String[] args) {
        Expr v = new Value(5);
        System.out.println(v.eval());

        Expr a = new Add(((Value) v), new Value(8));
        System.out.println(a.eval());

        Expr r = new SquaredRoot((Value) v);
        System.out.println(r.toString());
    }
}
