package fr.dauphine.javaavance.exception;

public class Enterprise {
    /*
    Write an Enterprise class. A company has a number of employees, a capital, a name, a mission, and a
    public String mission() method which returns the mission of the company and which declares the exception to be
    thrown SecretMissionException . We will also have a public int capital() method which returns the capital and which
    declares the throwing of the exception NonProfitException.
    Write a class CompanySecret which inherits from Company and whose mission method throws SecretMissionException.
    Write a class CompanyWithoutProfit which inherits from Company and whose capital method throws the exception NonProfitException.
    Write a method that takes an array of companies as input and displays the mission and capital of all companies (when possible).
    Test the method on the companies ”Ford”, ”CIA”, ”Spectre”, ”CroixRouge”, ”Microsoft”, ”ParisDiderot”.
     */
    private final int capital;
    private final String mission;
    private final String name;
    private final int numberOfEmployees;

    public Enterprise(int capital, String name, String mission, int numberOfEmployees) {
        this.capital = capital;
        this.mission = mission;
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;

    }

    /**
     * @return the mission of the company and which declares the exception to be thrown SecretMissionException
     */
    public String mission() throws SecretMissionException {
        if (mission == null) {
            throw new SecretMissionException("Mission is secret");
        }
        return mission;
    }

    /**
     * @return the capital and which declares the throwing of the exception NonProfitException
     */

    public int capital() throws NonProfitException {
        if (capital == 0) {
            throw new NonProfitException("Company is not profitable");
        }
        return capital;
    }

    static class NonProfitException extends Exception {
        public NonProfitException(String message) {
            super(message);
        }
    }

    static class SecretMissionException extends Exception {
        public SecretMissionException(String message) {
            super(message);
        }
    }

    /*
    Write a method that takes an array of companies as input and displays the mission and capital of all companies (when possible).
    Test the method on the companies ”Ford”, ”CIA”, ”Spectre”, ”CroixRouge”, ”Microsoft”, ”ParisDiderot”.
     */
    public static void main(String[] args) {
        Enterprise[] enterprises = new Enterprise[6];
        enterprises[0] = new Enterprise(100, "Ford", "Make cars", 1000);
        enterprises[1] = new EntrepriseSecrete(0, "CIA", null, 10000);
        enterprises[2] = new EntrepriseSecrete(1000, "Spectre", null, 10000);
        enterprises[3] = new EntrepriseSansProfit(0, "CroixRouge", "Help people", 10000);
        enterprises[4] = new Enterprise(1000, "Microsoft", "Make software", 10000);
        enterprises[5] = new Enterprise(1000, "ParisDiderot", "Make software", 10000);
        for (Enterprise enterprise : enterprises) {
            try {
                System.out.println(enterprise.mission());
            } catch (SecretMissionException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(enterprise.capital());
            } catch (NonProfitException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
