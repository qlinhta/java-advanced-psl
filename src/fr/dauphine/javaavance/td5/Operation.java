package fr.dauphine.javaavance.td5;

public enum Operation {
    PLUS("+") {
        @Override
        public double compute(double a, double b) {
            return a + b;
        }
    },
    MINUS("-") {
        @Override
        public double compute(double a, double b) {
            return a - b;
        }
    },
    MULT("*") {
        @Override
        public double compute(double a, double b) {
            return a * b;
        }
    },
    DIV("/") {
        @Override
        public double compute(double a, double b) {
            return a / b;
        }
    };

    private String symbol;

    private Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract double compute(double a, double b);

    @Override
    public String toString() {
        return symbol;
    }

    public static void main(String[] args) {
        System.out.println(Operation.PLUS.toString());
        System.out.println(Operation.DIV.toString());
        System.out.println(Operation.MULT.compute(5, 4));
    }

}
