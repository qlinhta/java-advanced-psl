package fr.dauphine.javaavance.td1;

public class EE02 {

    /*
    See class Point.java
     */

    /*
    2. Create a class TestPoint with a main and the same code as before. What happens ? How can we fix it ?
    >>
    The code doesn't work because the variables are private. We can fix it by making the variables public or by adding a getter method.
    See class TestPoint.java
     */

    /*
    3. Why do you need to set all fields visibility to private ?
    >> To prevent the user from changing the values of the variables and to prevent the user from accessing the variables directly
    Also encapsulate the access to your object variable keeping the control of the object status. (see class Point.java)


    4. What is an accessor ? Do we have to do it here ?
    >> An accessor is a method that returns the value of an instance variable
    >> The variable is private so we need to use an accessor

    5. Create a constructor with two arguments (called px and py). What is the problem ?
    >> See class Point.java

    6. Modify the parameters of the constructor to call them x and y. What happens ?
    >> See class Point.java

    7. We would like to keep track of the number of Points that have been created so far. How to proceed ?
    >> See class Point.java

    8. Write a second contructor with a single Point p2 argument that copies the coordinates from p2 into
    the current Point. How does the compiler know which constructor to call ?
    >> See class Point.java

    9. Update the class so that a call to System.out.println(point); will print the point coordinates as follows : (x, y).
    >> See class Point.java
     */




}
