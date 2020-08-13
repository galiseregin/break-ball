//322060187
package assfive;

import assthree.Ball;
import assthree.Block;

/**
 * listening when will accrue a hit.
 **/
public interface HitListener {
    /**
     * @param beingHit This method is called whenever the beingHit object is hit.
     * @param hitter   The hitter parameter is the Ball that's doing the hitting.
     **/
    void hitEvent(Block beingHit, Ball hitter);
}
