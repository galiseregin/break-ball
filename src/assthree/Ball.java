// ID: 322060187
package assthree;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * func create static ball.
 */
public class Ball implements Sprite {
    private GameEnvironment env;
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;

    // constructor

    /**
     * @param color  -color of the circles from the main
     * @param center -center of circle
     * @param r      -radius of circle
     */

    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.color = color;
        this.r = r;
    }

    /**
     * @param r      radius
     * @param color1 color of circle
     * @param y1     y index of center of circle
     * @param x1     x index of center of circle
     */

    public Ball(int x1, int y1, int r, java.awt.Color color1) {
        this.center = new Point(x1, y1);
        this.color = color1;
        this.r = r;
    }

    /**
     * @param color  -constructor.
     * @param r      -contractor.
     * @param center .
     * @param env    .
     */
    public Ball(GameEnvironment env, Point center, int r, Color color) {
        this.env = env;
        this.color = color;
        this.r = r;
        this.center = center;
        v = new Velocity(0, 0);
    }


    /**
     * @return func return x index of circle
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return func return y index of circle
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return func return radius of circle
     */
    public int getSize() {

        return this.r;
    }

    /**
     * @return func return color of circle
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @param surface draw the circle and fill it with color.
     */
    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), r);
    }

    /**
     * @param dx distance for velocity to make bouncing balls
     * @param dy distance for velocity to make bouncing balls
     */

    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * @return back velocity for bouncing ball
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * @param v1 constructor
     */
    public void setVelocity(Velocity v1) {

        this.v = v1;
    }

    /**
     * @param down  side of board
     * @param left  side of board
     * @param right side of board
     * @param up    side of board
     */
    public void moveOneStep(int left, int right, int down, int up) {
        //check if the ball is inside the board after moving
        if (center.getX() - this.r + this.v.getDx() <= left) {
            setVelocity(-this.v.getDx(), this.v.getDy());
        }
        if (center.getX() + this.r + this.v.getDx() >= right) {
            this.setVelocity(-this.v.getDx(), this.v.getDy());
        }
        if (center.getY() - this.r + this.v.getDy() <= up) {
            setVelocity(this.v.getDx(), -this.v.getDy());
        }
        if (center.getY() + this.r + this.v.getDy() >= down) {
            setVelocity(this.v.getDx(), -this.v.getDy());
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * func change the ball center due to the sigh of velocity.
     */
    public void moveOneStep() {
        Line trajectory = new Line(center, v.applyToPoint(center));
        CollisionInfo inf = this.env.getClosestCollision(trajectory);

        if (inf == null) {
            center = trajectory.end();
        } else {
            double x = inf.collisionPoint().getX();
            double y = inf.collisionPoint().getY();
            Velocity velocity = inf.collisionObject().hit(this, inf.collisionPoint(), this.v);
            if (this.v.getDy() != velocity.getDy()) {
                if (velocity.getDy() > 0) {
                    y += r;
                } else if (velocity.getDy() < 0) {
                    y -= r;
                }
            }
            if (this.v.getDx() != velocity.getDx()) {
                if (velocity.getDx() > 0) {
                    x += r;
                } else if (velocity.getDx() < 0) {
                    x -= r;
                }
            }
            this.v = velocity;

            center = new Point(x, y);
        }
    }

    /**
     * @param game -setting game environment
     */
    public void setGameEnvironment(GameEnvironment game) {
        this.env = game;
    }

    /**
     * while time pass we make ball movement to the next center.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * @param g - add the new sprite to game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * @param g - remove the new sprite from the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

}
