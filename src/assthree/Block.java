//322060187
package assthree;

import assfive.HitListener;
import assfive.HitNotifier;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Block class .
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private java.awt.Color color;
    private Rectangle rectangle;

    /**
     * @param rect  -rectangle
     * @param color Color of rectangle
     *              constructor.
     */
    public Block(Rectangle rect, java.awt.Color color) {
        this.color = color;
        this.rectangle = rect;
        hitListeners = new ArrayList<>();
    }

    /**
     * @return rectangle we collide with
     */

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * @param currentVelocity -the start ball velocity we get
     * @param collisionPoint  -the collision point of the ball with the block
     * @param hitter          -the ball that hit the block
     * @return new velocity after changing the direction
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //check if the ball is inside the board after moving
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        double w = rectangle.getWidth();
        double h = rectangle.getHeight();
        double eps = 0.0001;
        double eps2 = 5;
        Point upperLeft = new Point(rectangle.getUpperLeft().getX(), rectangle.getUpperLeft().getY());
        //if the ball is getting a bit after the left side
        if ((collisionPoint.getX() + eps >= upperLeft.getX()) && (upperLeft.getX() >= collisionPoint.getX() - eps)) {
            dx = -dx;
            //if the ball is getting a bit after the right side
        } else if ((collisionPoint.getX() + eps2 >= rectangle.getUpperLeft().getX() + w)
                && (rectangle.getUpperLeft().getX() + w >= collisionPoint.getX() - eps2)) {
            dx = -dx;
        }
        //if the ball is getting a bit after the up board
        if ((collisionPoint.getY() + eps >= upperLeft.getY()) && (upperLeft.getY() >= collisionPoint.getY() - eps)) {
            dy = -dy;
            //if the ball is getting a bit after the down board
        } else if ((collisionPoint.getY() + eps2 >= rectangle.getUpperLeft().getY() + h)
                && (rectangle.getUpperLeft().getY() + h >= collisionPoint.getY() - eps2)) {
            dy = -dy;
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }

    /**
     * @param surface drawing the rectangle in the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        double x = this.rectangle.getUpperLeft().getX();
        double y = this.rectangle.getUpperLeft().getY();
        double w = this.rectangle.getWidth();
        double h = this.rectangle.getHeight();
        surface.fillRectangle((int) x, (int) y, (int) w, (int) h);
        surface.setColor(Color.black);
        surface.drawRectangle((int) x, (int) y, (int) w, (int) h);
    }

    /**
     * timePassed method for future exercises.
     */
    public void timePassed() {
        //empty for now
    }

    /**
     * @param g -add to game collide and sprite
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * @param game -remove broken block from game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * @param hl -add listener to the game
     */
    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    /**
     * @param hl -remove listener from game
     */
    @Override
    public void removeHitListener(HitListener hl) {
        if (hitListeners.size() != 0) {
            hitListeners.remove(hl);
        }
    }

    /**
     * @param hitter -notify there was a hit.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}

