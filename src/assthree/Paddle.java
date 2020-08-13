//322060187
package assthree;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * class paddle create paddle that is like rectangle and if move from left to right side.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private java.awt.Color color;
    private Rectangle rect;
    private Point upperLeft;
    private double w;
    private double h;
    private double x;
    private double y;

    /**
     * @param color -color paddle
     * @param gui   -the board gui
     * @param rect  -rectangle
     *              contractor
     */
    public Paddle(Rectangle rect, biuoop.GUI gui, java.awt.Color color) {
        this.rect = rect;
        this.upperLeft = rect.getUpperLeft();
        this.h = rect.getHeight();
        this.w = rect.getWidth();
        this.keyboard = gui.getKeyboardSensor();
        this.x = rect.getUpperLeft().getX();
        this.y = rect.getUpperLeft().getY();
        this.color = color;
    }

    /**
     * while the block is not hitting the left side of the board the x parameter of point is getting smaller.
     */
    public void moveLeft() {
        if (x > 20) {
            x -= 5;
            upperLeft = new Point(x, y);
            rect = new Rectangle(upperLeft, w, h);
        }
    }

    /**
     * while the block is not hitting the right side of the board the x parameter of point is getting bigger.
     */
    public void moveRight() {
        if (x + w < 780) {
            x += 5;
            upperLeft = new Point(x, y);
            rect = new Rectangle(upperLeft, w, h);

        }
    }

    /**
     * if right key is pressed we move right same for left.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
    }

    /**
     * @param d -making the paddle with color and sizes
     */
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) x, (int) y, (int) w, (int) h);
        d.setColor(Color.BLACK);
        d.drawRectangle((int) x, (int) y, (int) w, (int) h);
    }

    /**
     * @return -returning the rectangle (paddle) that we collide with
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * @param collisionPoint  -the point that the collision accrue
     * @param currentVelocity -is the velocity of the ball
     * @param hitter          ball that hit
     * @return -velocity after the change in the angle
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //upper left point
        Point p = new Point(x, y);
        //initializing angle
        double angle = 20;
        //finding start speed with the velocity given
        double speed = currentVelocity.paddleMath();
        //making five zones in the paddle
        double w1 = w / 5;
        double w2 = 2 * w / 5;
        double w3 = 3 * w / 5;
        double w4 = 4 * w / 5;
        double w5 = w;
        if (collisionPoint.getX() >= upperLeft.getX() && collisionPoint.getX() < upperLeft.getX() + w1) {
            angle = -60;
        } else if (collisionPoint.getX() >= upperLeft.getX() + w1 && collisionPoint.getX() < upperLeft.getX() + w2) {
            angle = -30;
        } else if (collisionPoint.getX() >= upperLeft.getX() + w3 && collisionPoint.getX() < upperLeft.getX() + w4) {
            angle = 30;
        } else if (collisionPoint.getX() >= upperLeft.getX() + w4 && collisionPoint.getX() <= upperLeft.getX() + w5) {
            angle = 60;
        }

        return Velocity.fromAngleAndSpeed(angle, speed);
    }

    /**
     * @param g -Add this paddle to the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}
