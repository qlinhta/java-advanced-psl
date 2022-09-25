package fr.dauphine.javaavance.td1;

public class EE05 {

    /*
    1. Add a method translate(dx, dy) in Point. What are the different options to write this method ?
    >> See my answer in class Point.java (2 options) : modify the current point or return a new point
     */

    /*
    2. A circle can be represented with a center and a radius. Write a new Circle class.
    Don’t forget the constructor.
    >> See class Circle.java
     */

    /*
    3. Write the toString method.
    >> See class Point.java
     */

    /*
    4. Write the translate(dx, dy) that translate the circle.
    >> See class Circle.java
     */

    /*
    5.
        Point p = new Point(1, 2);
        Circle c = new Circle(p, 1);
        Circle c2 = new Circle(p, 2);
        c2.translateCircle(1, 1);
        System.out.println(c + " " + c2);

        What is the problem with this code ? How to avoid it ?

        >>
        The problem is that the center of the circle is the same object as the center of the circle c2.
        So when we translate the circle c2, we also translate the center of the circle c.
        To avoid this problem, we can create a new point in the translateCircle method.
     */

    /*
    6. What would be the problem with a getCenter() method that would return the center ?
    >> The problem is that the center of the circle is the same object as the center of the circle c2.
     */

    /*
    7. Add area() and update toString() to print the area as well.
    >> See class Circle.java
     */

    /*
    8. Add a contains(Point p) method to return true if p is inside the circle (hint :use Pythagoras theorem).
    >> See class Circle.java
     */

    /*
    9. Add contains(Point p, Circle...circles) that will return true of the point is inside one of the circles ?
    What other change should you do about the method declaration ? Why ?
    >> The method should be static because it doesn't need to access the instance variables of the class
     */


}
