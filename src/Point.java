public class Point {
    private int x;
    private int y;

    /*
    Create a constructor with two arguments (called px and py). What is the problem ?
    >> The variables are private, we cannot access them from outside the class
    >> Solution: make the variables public or add a setter method
     */
    public Point(int px, int py){
        this.x = px;
        this.y = py;
    }

    /*
    6. Create a constructor with two arguments (called px and py). What is the problem ?
    >> Would be confusing when declaring constructor with two arguments have same name as the variables
     */

    /*
    7. We would like to keep track of the number of Points that have been created so far. How to proceed ?
    >> Create a static variable to keep track of the number of points created
     */

    /*
    8. Write a second contructor with a single Point p2 argument that copies the coordinates from p2 into
    the current Point. How does the compiler know which constructor to call ?
    >> The compiler will call the constructor with the same number of arguments
        public Point(Point p2){
        this.x = p2.x;
        this.y = p2.y;
     */

    /*
    9. Update the class so that a call to System.out.println(point); will print the point coordinates as follows : (x, y).
     */

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Point() {

    }

    /*
    3.2. Write a method isSameAs(Point) that will return true if the two points have the same coordinates.
     */
    public boolean isSameAs(Point p) {
        return this.x == p.x && this.y == p.y;
    }

    /*
    3.3
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

    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }
        return false;
    }

    public void draw() {
        Point p = new Point();
        System.out.println(p.x + " " + p.y);
    }
    // Why does this work?
    // >> Because the method is in the same class as the variables

    /*
    Add a method translate(dx, dy) in Point. What are the different options to write this method ?
    */

    // Option 1: return a new point
    public Point translate(int dx, int dy) {
        return new Point(x + dx, y + dy);
    }

    // Option 2: modify the current point
    public void translateByModifyCurrentPoint(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
