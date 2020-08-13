// ID: 322060187
package assthree;

import java.util.ArrayList;
import java.util.List;

/**
 * class create rectangle with width point and hight and check if the rectangle intersect with ball tracery of line .
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * @param height    -height of rectangle
     * @param upperLeft -upperLeft Point of rectangle
     * @param width     -width of rectangle
     *                  Create a new rectangle with location and width/height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.height = height;
        this.upperLeft = upperLeft;
        this.width = width;
    }

    /**
     * @param line -check if line of rectangle intersect with ball tracery line
     * @return -a (possibly empty) List of intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        //lines of rectangle
        Line a = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY());
        Line b = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX(), upperLeft.getY() + height);
        Line c = new Line(upperLeft.getX(), upperLeft.getY() + height,
                upperLeft.getX() + width, upperLeft.getY() + height);
        Line d = new Line(upperLeft.getX() + width, upperLeft.getY(),
                upperLeft.getX() + width, upperLeft.getY() + height);
        //creating list of possible intersections
        List<Point> interPoint = new ArrayList<Point>();
        //check if one of the lines intersect if does add to the list
        if (a.isIntersecting(line) || b.isIntersecting(line) || c.isIntersecting(line) || d.isIntersecting(line)) {

            if (a.isIntersecting(line)) {
                interPoint.add(a.intersectionWith(line));
            } else if (b.isIntersecting(line)) {
                interPoint.add(b.intersectionWith(line));
            } else if (c.isIntersecting(line)) {
                interPoint.add(c.intersectionWith(line));
            } else if (d.isIntersecting(line)) {
                interPoint.add(d.intersectionWith(line));
            }

        }
        return interPoint;
    }

    /**
     * @return -width of rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return -height of rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return -upper-left point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

}
