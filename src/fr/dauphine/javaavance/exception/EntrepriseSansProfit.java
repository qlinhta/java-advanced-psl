package fr.dauphine.javaavance.exception;

public class EntrepriseSansProfit extends Enterprise {
    public EntrepriseSansProfit(int capital, String name, String mission, int numberOfEmployees) {
        super(capital, name, mission, numberOfEmployees);
    }

    @Override
    public int capital() throws NonProfitException {
        return super.capital();
    }
}