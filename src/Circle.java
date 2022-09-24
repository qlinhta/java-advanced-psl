public class Circle {
    /*
    A circle can be represented with a center and a radius. Write a new Circle class.
    Don’t forget the constructor.
     */

    private Point center;
    private int radius;


    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    /*
    Method toString() to print the circle, print out also area and radius, center.
     */
    public String toString() {
        return "Circle: center = " + center + ", radius = " + radius + ", area = " + area();
    }

    /*
    Write the translateCircle(dx, dy) that translate the circle.
     */
    public void translateCircle(int dx, int dy) {
        center.translateByModifyCurrentPoint(dx, dy);
        new Circle(center, radius);
    }

    // Method getCeneter() to get the center of the circle
    public Point getCenter() {
        return center;
    }

    // Method return the area of the circle
    public double area() {
        return Math.PI * radius * radius;
    }

    /*
    Add a contains(Point p) method to return true if p is inside the circle (hint :use Pythagoras theorem).
     */

    public boolean contains(Point p) {
        return Math.sqrt(Math.pow(p.getX() - center.getX(), 2) + Math.pow(p.getY() - center.getY(), 2)) < radius;
    }

    /*
    Add contains(Point p, Circle...circles) that will return true of the point is inside one of the circles ?
    What other change should you do about the method declaration ? Why ?
    >> The method should be static because it doesn't need to access the instance variables of the class
     */
    public static boolean contains(Point p, Circle...circles) {
        for (Circle circle : circles) {
            if (circle.contains(p)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Point p = new Point(1, 2);
        Circle c = new Circle(p, 1);
        Circle c2 = new Circle(p, 2);
        c2.translateCircle(1, 1);
        System.out.println(c + " " + c2);

        // What is the problem with this code ? How to avoid it ?
        /*
        The problem is that the center of the circle is the same object as the center of the circle c2.
        So when we translate the circle c2, we also translate the center of the circle c.
        To avoid this problem, we can create a new point in the translateCircle method.
         */


        Circle pop = new Circle(new Point(1, 2), 1);
        //return a center of the circle pop
        System.out.println(pop.getCenter().translate(1, 1));


        // Consider Circle pop, what would be the problem with a getCenter() method that would return the center?
        /*
        >>
         */

        System.out.println(pop);

    }
}
