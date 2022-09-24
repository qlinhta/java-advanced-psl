package fr.dauphine.javaavance.td1;

public class TestPoint {

    public void drawPoint() {
        Point p = new Point();
        //System.out.println(p.x + " " + p.y);
    }
    // Why doesn't this work when x, y are private ?
    /*
    >> Because the method is not in the same class as the variables, we cannot access the private variables
    >> Solution: make the variables public or add a getter method
     */

    public static void main(String[] args) {

    }
}
