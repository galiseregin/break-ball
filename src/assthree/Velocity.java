//322060187
package assthree;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */

public class Velocity {
    private double dx;
    private double dy;

    /**
     * @param dx distance between positions on x axe.
     * @param dy distance between positions on y axe.
     */

    // constructor
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @param angle we use it to what direction the item go.
     * @param speed how fast the body will move.
     * @return the velocity
     */

    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * @return distance on x axe.
     */

    public double getDx() {
        return this.dx;
    }

    /**
     * @return distance on y axe.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * @param p with position (x+dx, y+dy)
     * @return Take a point with position (x,y) and return a new point
     */

    public Point applyToPoint(Point p) {
        Point n = new Point(this.dx + p.getX(), this.dy + p.getY());
        return (n);
    }

    /**
     * @return -new velocity speed to hit func in Paddle class
     */

    public double paddleMath() {
        return Math.sqrt(getDx() * getDx() + getDy() * getDy());
    }

}
