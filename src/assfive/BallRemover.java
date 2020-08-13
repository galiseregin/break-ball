//322060187
package assfive;

import assthree.Ball;
import assthree.Block;
import assthree.GameLevel;

/**
 * ball remover is removing balls that get to dead zone.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param game         the game
     * @param removedBalls ball to remove
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     * if ball get out.
     *
     * @param beingHit is the dead zone
     * @param hitter   ball we remove
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        remainingBalls.decrease(1);
    }

    /**
     * @return -the amount of ball left.
     */
    public Counter getCounter() {
        return this.remainingBalls;
    }

    /**
     * increase number of remaind balls.
     */
    public void setter() {
        remainingBalls.increase(1);
    }
}

