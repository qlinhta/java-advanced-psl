public class Ring {

    /*
    Write a new class Ring, with a center and two radius (beware, the inner radius
    must always be smaller than the outer one.
     */

    private Point center;
    private int outerRadius;
    private int innerRadius;

    public Ring(Point center, int outerRadius, int innerRadius) {
        this.center = center;
        this.outerRadius = outerRadius;
        this.innerRadius = innerRadius;
    }

    /*
    Write equals.
     */

    public boolean equals(Ring ring) {
        return center.equals(ring.center) && outerRadius == ring.outerRadius && innerRadius == ring.innerRadius;
    }

    /*
    Write a toString.
     */
    public String toString() {
        return "Ring: center = " + center + ", outer radius = " + outerRadius + ", inner radius = " + innerRadius;
    }

    /*
    Write contains(Point p) that will return true if the point is inside the ring.
     */
    public boolean contains(Point p) {
        return Math.sqrt(Math.pow(p.getX() - center.getX(), 2) + Math.pow(p.getY() - center.getY(), 2)) < outerRadius
                && Math.sqrt(Math.pow(p.getX() - center.getX(), 2) + Math.pow(p.getY() - center.getY(), 2)) > innerRadius;
    }

    /*
    Write contains(Point p, Ring...rings) that will return true of the point is inside one of the rings ?
     */

    public static boolean contains(Point p, Ring...rings) {
        for (Ring ring : rings) {
            if (ring.contains(p)) {
                return true;
            }
        }
        return false;
    }

    /*
    For testing purposes only.
     */
    public static void main(String[] args) {
        // Make a ring
        Point center = new Point(0, 0);
        Ring ring = new Ring(center, 10, 5);
        System.out.println(ring);
        // test contains
        Point p = new Point(0, 0);
        System.out.println(ring.contains(p));
        // test equals
        Ring ring2 = new Ring(center, 10, 5);
        System.out.println(ring.equals(ring2));
        // test contains(Point p, Ring...rings)
        Ring ring3 = new Ring(center, 10, 5);
        Ring ring4 = new Ring(center, 10, 5);
        System.out.println(Ring.contains(p, ring3, ring4));


    }
}
