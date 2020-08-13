//322060187
package assfive;

import assthree.Ball;
import assthree.Block;

/**
 * update the counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * @param scoreCounter counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * @param beingHit This method is called whenever the beingHit object is hit.
     * @param hitter   The hitter parameter is the Ball that's doing the hitting.
     *                 increase the score by five when block is hit.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }

    /**
     * @return score
     */

    public Counter getScore() {
        return this.currentScore;
    }
}
