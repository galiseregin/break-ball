//322060187
package assthree;

/**
 * all the information of the collision.
 */

public class CollisionInfo {
    private Point p;
    private Collidable collidable;

    /**
     * @param p          -constructor
     * @param collidable -constructor
     */
    public CollisionInfo(Point p, Collidable collidable) {
        this.p = p;
        this.collidable = collidable;
    }

    /**
     * @return the point at which the collision occurs.
     */

    public Point collisionPoint() {
        return p;
    }

    /**
     * @return the object involved in the collision.
     */
    public Collidable collisionObject() {
        return collidable;
    }
}
