// ID: 322060187
package assthree;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * class point is getting pairs of dots from the main checking if they are similar and return there distance.
 */

public class Point {
    //creating fields.
    private double x;
    private double y;

    /**
     * @param x Field.
     * @param y Fields.
     *          using the fields to make constructor.
     */

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param x Field with int.
     * @param y Fields with int.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param other -the next point we will get.
     * @return distance -- return the distance of this point to the other point.
     */
    public double distance(Point other) {
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * @param other -the next point details.
     * @return true if the points are equal, false otherwise.
     */

    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return (this.x == other.getX()) && (this.y == other.getY());
    }

    /**
     * @return the x  value of this point.
     */

    public double getX() {
        return this.x;

    }


    /**
     * @return the y value of this point.
     */

    public double getY() {
        return this.y;
    }

    /**
     * @param d     -drawing the points .
     * @param color -because we have 2 kinds of points there is a need to differ between them.
     */

    public void drawPoint(DrawSurface d, Color color) {
        d.setColor(color);
        d.fillCircle((int) this.x, (int) this.y, 5);
    }

}

