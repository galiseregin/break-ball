//322060187
package assthree;

import java.util.ArrayList;
import java.util.List;

/**
 * this class is managing a list of collides adding collusion info and returning it.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * constructor of collides list.
     */
    public GameEnvironment() {
        collidables = new ArrayList<>();
    }

    /**
     * @param c -add the given collide to the environment.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * @param c -remove the given collide to the environment.
     **/
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    /**
     * @param trajectory -ball movement line.
     * @return If this object will not collide with any of the collides
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        //if in the first place in the list there is nothing it means the list is empty and there is no collides
        if (collidables != null && !collidables.isEmpty()) {
            Collidable collToReturn = null;
            Point pointToReturn = null;
            boolean collisionExists = false;
            List<Collidable> l = new ArrayList<>();
            for (Collidable c : this.collidables) {
                Rectangle rectangle = c.getCollisionRectangle();
                Point point = trajectory.closestIntersectionToStartOfLine(rectangle);
                if (point != null) {
                    collisionExists = true;
                    l.add(c);
                }
            }

            if (collisionExists) {
                Collidable a = l.get(0);
                Rectangle a1 = a.getCollisionRectangle();
                //the first intersection point we use to compare
                Point interMin = trajectory.closestIntersectionToStartOfLine(a1);
                //the min distance we will compare every future distance
                double mimDistance = interMin.distance(trajectory.start());
                //running on the list
                collToReturn = a;
                for (int i = 0; i < l.size(); i++) {
                    Collidable c = l.get(i);

                    //form of rectangle
                    Rectangle form = c.getCollisionRectangle();
                    //intersection point
                    Point closeP = trajectory.closestIntersectionToStartOfLine(form);
                    //save the Collision which distance is smaller
                    if (closeP != null && closeP.distance(trajectory.start()) < mimDistance) {
                        collToReturn = c;
                        mimDistance = closeP.distance(trajectory.start());
                    }
                    //create new rectangle that have the best Collision we found
                    Rectangle d = collToReturn.getCollisionRectangle();
                    //the point that we return is the point of intersection with Rectangle d
                    pointToReturn = trajectory.closestIntersectionToStartOfLine(d);
                }
                return new CollisionInfo(pointToReturn, collToReturn);
            }
        }
        return null;
    }

    /**
     * @return List of collides.
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }
}