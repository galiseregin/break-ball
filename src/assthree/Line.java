// ID: 322060187
package assthree;

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;

/**
 * class point is getting 4 dots and use them to work with lines.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * @param start first pair of points the program get from the main.
     * @param end   second pair.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @param x1 the first x index.
     * @param x2 the second x index.
     * @param y1 the first y index.
     * @param y2 the second y index.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }


    /**
     * @return func get start and end point and return distance between them using the method prom point class.
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * @return func return the middle point of line
     */
    // Returns the middle point of the line
    public Point middle() {
        double middleX = (start.getX() + end.getX()) / 2;
        double middleY = (start.getY() + end.getY()) / 2;
        return (new Point(middleX, middleY));
    }

    /**
     * @return return start point of line.
     */
    public Point start() {
        return new Point(start.getX(), start.getY());
    }

    /**
     * @return Returns the end point of the line.
     */

    public Point end() {
        return new Point(end.getX(), end.getY());
    }

    /**
     * @param other -the ball movement  line
     * @return true if 2 vertical lines intersect
     */
    public boolean isIntersectingVerticalLines(Line other) {
        int flag = 0;
        double eps = 0.00001;
        //incline m1 m2
        double m1 = ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
        double m2 = ((other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX()));
        if (this.start.getX() == this.end.getX() || other.start.getX() == other.end.getX()) {
            if (this.start.getX() == this.end.getX()) {
                if (this.start.getX() >= Math.min(other.start.getX(), other.end.getX() - eps)
                        && (this.start.getX() <= Math.max(other.start.getX(), other.end.getX()) + eps)) {
                    if (this.end.getY() >= Math.min(other.start.getY(), other.end.getY() - eps)
                            && (this.start.getY() <= Math.max(other.start.getY(), other.end.getY()) + eps)) {
                        flag = 10;
                    }
                }
            } else if (other.start.getX() == other.end.getX()) {
                if (other.start.getX() >= Math.min(this.start.getX(), this.end.getX() - eps)
                        && (other.start.getX() <= Math.max(this.start.getX(), this.end.getX()) + eps)) {
                    if (other.end.getY() >= Math.min(this.start.getY(), this.end.getY() - eps)
                            && (other.start.getY() <= Math.max(this.start.getY(), this.end.getY()) + eps)) {
                        flag = 10;
                    }
                }
            }
            if ((flag == 10) && (this.start.getX() == this.end.getX()) && (other.start.getX() == other.end.getX())) {
                flag = 0;
                if (this.end.getY() == other.start.getY()) {
                    if (other.start.getY() >= this.start.getY()) {
                        if (other.end.getY() >= other.start.getY()) {
                            flag = 1;
                        }
                    }
                    if (other.start.getY() <= this.start.getY()) {
                        if (other.end.getY() <= other.start.getY()) {
                            flag = 1;
                        }
                    }
                }
                if (this.start.getY() == other.end.getY()) {
                    if (other.end.getY() <= this.end.getY()) {
                        if (other.start.getY() <= other.end.getY()) {
                            flag = 1;
                        }
                    }
                    if (other.end.getY() >= this.end.getY()) {
                        if (other.start.getY() >= other.end.getY()) {
                            flag = 1;
                        }
                    }
                } else if (this.end.getY() == other.end.getY()) {
                    if (this.end.getY() <= this.start.getY()) {
                        if (other.end.getY() >= other.start.getY()) {
                            flag = 1;
                        }
                    }
                    if (this.end.getY() >= this.start.getY()) {
                        if (other.end.getY() <= other.start.getY()) {
                            flag = 1;
                        }
                    }
                } else if (this.start.getY() == other.start.getY()) {
                    if (this.end.getY() <= this.start.getY()) {
                        if (other.end.getY() >= other.start.getY()) {
                            flag = 1;
                        }
                    }
                    if (this.end.getY() >= this.start.getY()) {
                        if (other.end.getY() <= other.start.getY()) {
                            flag = 1;
                        }
                    }
                }
            }
        }
        return (flag == 10 || flag == 1);
    }

    /**
     * @param other - the other line that is created for second pair of points that he program get.
     * @return returns true if the lines intersect, false otherwise.
     */

    public boolean isIntersecting(Line other) {
        int flag = 0;
        double eps = 0.00001;
        //incline m1 m2
        double m1 = ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
        double m2 = ((other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX()));
        if (m1 == m2) {
            if (this.end.getX() == other.start.getX() && this.end.getY() == other.start.getY()) {
                if (other.start.getX() >= this.start.getX()) {
                    if (other.end.getX() >= other.start.getX()) {
                        flag = 1;
                    }
                }
                if (other.start.getX() <= this.start.getX()) {
                    if (other.end.getX() <= other.start.getX()) {
                        flag = 1;
                    }
                }
            }
            if (this.start.getX() == other.end.getX() && this.start.getY() == other.end.getY()) {
                if (other.end.getX() <= this.end.getX()) {
                    if (other.start.getX() <= other.end.getX()) {
                        flag = 1;
                    }
                }
                if (other.end.getX() >= this.end.getX()) {
                    if (other.start.getX() >= other.end.getX()) {
                        flag = 1;
                    }
                }
            } else if (this.end.getX() == other.end.getX() && this.end.getY() == other.end.getY()) {
                if (this.end.getX() <= this.start.getX()) {
                    if (other.end.getX() >= other.start.getX()) {
                        flag = 1;
                    }
                }
                if (this.end.getX() >= this.start.getX()) {
                    if (other.end.getX() <= other.start.getX()) {
                        flag = 1;
                    }
                }
            } else if (this.start.getX() == other.start.getX() && this.start.getY() == other.start.getY()) {
                if (this.end.getX() <= this.start.getX()) {
                    if (other.end.getX() >= other.start.getX()) {
                        flag = 1;
                    }
                }
                if (this.end.getX() >= this.start.getX()) {
                    if (other.end.getX() <= other.start.getX()) {
                        flag = 1;
                    }
                }
            }
        } else if (m1 - m2 != 0) {
            //means that there is some kind of intersection
            double meterOfX = other.start.getY() - m2 * other.start.getX() - this.start.getY() + m1 * this.start.getX();
            double x = (meterOfX) / (m1 - m2);
            double y = (this.start.getY() + m1 * (x - this.start.getX()));
            //the intersection point
            //check if the intersection point is between the points of line.
            if (this.end.getX() > this.start.getX()) {
                //checking the rang of x intersection parameter.
                //if end x is bigger than start x
                if (this.start.getX() - eps <= x && x <= this.end.getX() + eps) {
                    if (this.end.getY() > this.start.getY()) {
                        //if end y is bigger of the start y
                        if (this.start.getY() - eps <= y && y <= this.end.getY() + eps) {
                            //flag 2 means the point is working for the first line
                            flag = 2;
                        }
                    } else {
                        if (this.end.getY() - eps <= y && y <= this.start.getY() + eps) {
                            flag = 2;
                        }
                    }
                }
            } else {
                if (this.end.getX() - eps < x && x < this.start.getX() + eps) {
                    //if end x is smaller than the first x
                    if (this.end.getY() > this.start.getY()) {
                        //if end y is bigger than the first y
                        if (this.start.getY() - eps <= y && y <= this.end.getY() + eps) {
                            flag = 2;
                        }
                    } else {
                        if (this.end.getY() - eps <= y && y <= this.start.getY() + eps) {
                            flag = 2;
                        }
                    }
                }
            }
            if (flag == 2) {
                //if x is between points of the first line check for the second line
                if (other.end.getX() > other.start.getX()) {
                    if (other.start.getX() - eps <= x && x <= other.end.getX() + eps) {
                        if (other.end.getY() > other.start.getY()) {
                            if (other.start.getY() - eps <= y && y <= other.end.getY() + eps) {
                                //flag 1 means that the condition works for second line.
                                flag = 1;
                            }
                        } else {
                            if (other.end.getY() - eps <= y && y <= other.start.getY() + eps) {
                                flag = 1;
                            }
                        }
                    }
                } else {
                    if (other.end.getX() - eps < x && x < other.start.getX() + eps) {
                        if (other.end.getY() > other.start.getY()) {
                            if (other.start.getY() - eps <= y && y <= other.end.getY() + eps) {
                                flag = 1;
                            }
                        } else {
                            if (other.end.getY() - eps <= y && y <= other.start.getY() + eps) {
                                flag = 1;
                            }
                        }
                    }
                }
            }
            //checking case if the lines intersect in their points.
            if ((flag == 1) && (other.end.getY() == this.start.getY())) {
                if ((this.end.getX() == other.start.getX()) || (other.end.getX() == this.start.getX())) {
                    flag = 3;
                } else if (other.start.getX() < this.start.getX() && this.start.getX() < other.end.getX()) {
                    if (this.start.getX() < other.end.getX() && other.end.getX() < this.end.getX()) {
                        flag = 3;
                    }
                } else if (this.start.getX() < other.start.getX() && other.start.getX() < this.end.getX()) {
                    if (other.start.getX() < this.end.getX() && this.end.getX() < other.end.getX()) {
                        flag = 3;
                    }
                } else {
                    flag = 0;
                }
            }
        }
        return ((flag == 1) || (isIntersectingVerticalLines(other)) || ((flag == 3) && (m1 != m2)));
    }

    /**
     * @param other -the second line.
     * @return Returns the intersection point if the lines intersect,and null otherwise.
     */

    public Point intersectionWith(Line other) {
        double x = 0;
        double y = 0;
        if (this.isIntersecting(other)) {
            if (this.end.getX() == this.start.getX()) {
                //y-y1=m*(x-x1)
                double m2 = ((other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX()));
                x = this.end.getX();
                y = other.start.getY() + m2 * (x - other.start.getX());
            } else if (other.end.getX() == other.start.getX()) {
                double m1 = ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
                x = other.end.getX();
                y = this.start.getY() + m1 * (x - this.start.getX());
            } else {
                double m1 = ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
                double m2 = ((other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX()));
                double meterOfX = other.start.getY() - m2 * other.start.getX() - this.start.getY()
                        + m1 * this.start.getX();
                x = (meterOfX) / (m1 - m2);
                y = (this.start.getY() + m1 * (x - this.start.getX()));
            }
        }
        if (isIntersecting(other)) {
            return (new Point(x, y));
        } else {
            return (null);
        }
    }

    /**
     * @param other - line .
     * @return true is the lines are equal, false otherwise.
     */

    // equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        int check = 0;
        if (this.end.getX() == other.end.getX() && (this.start.getX() == other.start.getX())) {
            check = 1;
        }
        return ((!isIntersecting(other)) && (check == 1));
    }

    /**
     * @param d - setting color for line to be black.
     */

    public void drawLine(DrawSurface d) {
        d.setColor(Color.black);
        d.drawLine((int) this.start.getX(), (int) this.start.getY(), (int) this.end.getX(), (int) this.end.getY());
    }

    /**
     * @param rect - the rectangle that the ball is intersecting with.
     *             If this line does not intersect with the rectangle, return null.
     *             Otherwise, return the closest intersection point to the
     *             start of the line.
     * @return -the closest point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> p = rect.intersectionPoints(this);
        //if the size is bigger then 2 the lines the lines is on the rect
        if (p.isEmpty() || p.size() > 2) {
            return null;
        }
        //there is only one intersection point
        if (p.size() == 1) {
            return p.get(0);
        } else {
            //2 intersection points check which one is closer
            Point a = p.get(0);
            Point b = p.get(1);
            if (a.distance(this.start) > b.distance(this.start)) {
                return b;
            }
            return a;
        }
    }
}