package fr.dauphine.javaavance.exception;

public class EE02 {
    /*
    The parseInt method is specified as follows:
        public static intparseInt(Strings)
            throws NumberFormatException

    Use this method to sum all integers given as command-line arguments, ignoring other arguments.
     */

    public static void main(String[] args) {
        int sum = 0;
        for (String arg : args) {
            try {
                sum += Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                System.out.println("Argument " + arg + " is not an integer");
            }
        }
        System.out.println("Sum of integers: " + sum);
    }
}
