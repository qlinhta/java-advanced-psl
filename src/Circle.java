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
    Method toString() to print the circle
     */
    public String toString() {
        return "Circle: center = " + center + ", radius = " + radius;
    }

    /*
    Write the translateCircle(dx, dy) that translate the circle.
     */
    public void translateCircle(int dx, int dy) {
        center.translateByModifyCurrentPoint(dx, dy);
        new Circle(center, radius);
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        Circle c = new Circle(p, 1);
        Circle c2 = new Circle(p, 2);
        c2.translateCircle(1, 1);
        System.out.println(c + " " + c2);
    }





}
