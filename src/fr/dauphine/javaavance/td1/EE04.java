package fr.dauphine.javaavance.td1;

import java.util.LinkedList;

public class EE04 {

    /*
    We use the class Point from the previous exercise.
    We now want to write a class to represent a polygonal line.
    The polyline will have a maximum number of points that can vary
    from one instance to another (but is a constant for a single polyline instance).
     */
    private Point[] points;
    private int maxPoints;

    /*
    1. You will use an array to store the Points of the polyline. Write the constructor for PolyLine
     */
    public EE04(int maxPoints) {
        this.maxPoints = maxPoints;
        points = new Point[maxPoints];
    }

    /*
    2. Write a method add that can be used to add a new point to the line.
    What happens if we add more points that the maximum capacity of the array ?
    What to do about it ?
     */
    // if limit is reached, raise an exception
    public void add(Point p) throws Exception {
        for (int i = 0; i < maxPoints; i++) {
            if (points[i] == null) {
                points[i] = p;
                return;
            }
        }
        throw new Exception("Limit reached");
    }

    /*
    3. Write a method pointCapacity() and nbPoints() that will return the maximum
    capacity of the polyline and the number points currently in the polyline.
     */
    public void pointCapacity() {
        System.out.println(maxPoints);
    }

    public void nbPoints() {
        int count = 0;
        for (int i = 0; i < maxPoints; i++) {
            if (points[i] != null) {
                count++;
            }
        }
        System.out.println(count);
    }

    /*
    4. Write a method contains which will return true if a given point is in the
    polyline. Use a for each loop to do this (instead of a classical index based loop).
     */
    // Check if a point is in the polyline
    public boolean contains(Point p) {
        for (Point point : points) {
            if (point != null && point.equals(p)) {
                return true;
            }
        }
        return false;
    }

    /*
    5. What happens if null is given instead of an actual Point object ? What if you
    do add(null) before ? Read about Objects.requireNonNull(o).

    >>
    Objects.requireNonNull(o) throws a NullPointerException if o is null.

     */

    /*
    6. Update the class and use a LinkedList instead of an array (and remove the maximum capacity limit).
    How to update pointCapacity, nbPoints and contains ?

    >>
    From here I work on a LinkedList instead of an array (and remove the maximum capacity limit)
    In this case, I supposed that the user will not add null pointsList, so I don't check it
    and the capacity is 10, but it can be changed with condition in for loop while adding points
     */
    public LinkedList<Point> pointsList = new LinkedList<>();

    //new contructor
    public EE04() {
    }

    /*
     update add method, supposed that limit is 10, throw an exception if limit is reached
     */
    public void addList(Point p) throws Exception {
        if (pointsList.size() < 10) {
            pointsList.add(p);
        } else {
            throw new Exception("Limit reached");
        }
    }

    // update pointCapacity method, supposed that limit is 10, throw an exception if limit is reached
    public void pointCapacityList() {
        System.out.println(10);
    }

    // update nbPoints method
    public void nbPointsList() {
        System.out.println(pointsList.size());
    }

    // update contains method, check if a point is in the list
    public boolean containsList(Point p) {
        for (Point point : pointsList) {
            if (point != null && point.equals(p)) {
                return true;
            }
        }
        return false;
    }

    // For testing purposes only

    public static void main(String[] args) throws Exception {

        // Declare some points
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        Point p4 = new Point(7, 8);
        Point p5 = new Point(9, 10);

        // Test a polyline with a maximum of 3 points
        EE04 pl1 = new EE04(3);
        pl1.add(p1);
        pl1.add(p2);
        pl1.add(p3);
        //pl1.add(p4);
        //pl1.add(p5);
        pl1.pointCapacity();
        pl1.nbPoints();
        System.out.println(pl1.contains(p1));
        System.out.println(pl1.contains(p4));
        System.out.println(pl1.contains(p5));

        // Test a polyline with a maximum of 3 pointsList
        EE04 pl2 = new EE04();
        pl2.addList(p1);
        pl2.addList(p2);
        pl2.addList(p3);
        //pl2.addList(p4);
        //pl2.addList(p5);
        pl2.pointCapacityList();
        pl2.nbPointsList();
        System.out.println(pl2.containsList(p1));
        System.out.println(pl2.containsList(p4));
        System.out.println(pl2.containsList(p5));
    }
}
