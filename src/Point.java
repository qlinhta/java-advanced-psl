public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

    }

    public void drawPoint() {
        Point p = new Point();
        System.out.println(p.x + " " + p.y);
    }

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

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
