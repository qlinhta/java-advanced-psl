public class EE03 {

    /*
    1.
    Point p1=new Point(1,2);
    Point p2=p1;
    Point p3=new Point(1,2);

    System.out.println(p1==p2);
    System.out.println(p1==p3);

    What does this code print ? Why?
    >> This code prints true and false because p1 and p2 are the same object, but p3 is a different object

    */

    /*
    2. Write a method isSameAs(Point) that will return true if the two points have the same coordinates.
    >> See class Point.java
     */

    /*
    3.
    Point p1=new Point(1,2);
    Point p2=p1;
    Point p3=new Point(1,2);

    ArrayList<Point> list = new ArrayList<>();
    list.add(p1);
    System.out.println(list.indexOf(p2));
    System.out.println(list.indexOf(p3));

    What is the problem with this code ? Read the documentation of indexOf and check which method is called.
    Modify the Point class to fix this problem.
    >> The problem is that the indexOf method is using the equals method to compare the objects, but the equals method
    is not implemented in the Point class. So the indexOf method is using the equals method from the Object class, which
    is comparing the references of the objects. To fix this problem, we need to implement the equals method in the Point class.
     */


}
