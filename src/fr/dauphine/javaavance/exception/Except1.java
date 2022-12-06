package fr.dauphine.javaavance.exception;

import java.io.IOException;

/*
Run the following class, and explain the reason for its behavior.
 */

public class Except1 {

    public void methodeA(String args[]) {
        System.out.println("	methodeA : debut");
        try {
            System.out.println("	methodeA : appel de methodeB");
            this.methodeB(args);
            System.out.println("	methodeA : retour de methodeB");
            if (args.length > 99) throw new IOException();
        } catch (IOException e) {
            System.out.println("	methodeA : capture : " + e);
        } finally {
            System.out.println("	methodeA : execute finally");
        }
        System.out.println("	methodeA : fin");
    }

    public void methodeB(String args[]) {
        System.out.println("	methodeB : debut");
        try {
            System.out.println("	methodeB : tente d’acceder a args[99]");
            String s = args[99];
            System.out.println("	methodeB : a reussi a acceder a args[99]");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("	methodeB : capture : " + e);
        } finally {
            System.out.println("	methodeB : execute finally");
        }
        System.out.println("	methodeB : fin");
    }

    public static void main(String args[]) {
        System.out.println("main : debut");
        Except1 ex = new Except1();
        try {
            System.out.println("main : appel de methodeA");
            ex.methodeA(args);
            System.out.println("main : retour de methodeA");
        } catch (Exception e) {

            System.out.println("main : capture : " + e);
        }
        System.out.println("main : fin");
    }
}

/*
Output:

    main : debut
    main : appel de methodeA
        methodeA : debut
        methodeA : appel de methodeB
        methodeB : debut
        methodeB : tente d’acceder a args[99]
        methodeB : capture : java.lang.ArrayIndexOutOfBoundsException: Index 99 out of bounds for length 0
        methodeB : execute finally
        methodeB : fin
        methodeA : retour de methodeB
        methodeA : execute finally
        methodeA : fin
    main : retour de methodeA
    main : fin

 */
