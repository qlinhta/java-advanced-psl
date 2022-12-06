package fr.dauphine.javaavance.exception;

public class EntrepriseSecrete extends Enterprise {
    public EntrepriseSecrete(int capital, String name, String mission, int numberOfEmployees) {
        super(capital, name, mission, numberOfEmployees);
    }

    @Override
    public String mission() throws SecretMissionException {
        return super.mission();
    }
}