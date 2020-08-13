//322060187
package assfive;

import assthree.Ball;
import assthree.Block;
import assthree.GameLevel;

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 **/
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * @param game          the game
     * @param removedBlocks blocks to remove
     **/
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Blocks that are hit and reach 0 hit-points should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param hitter   ball that hit
     * @param beingHit block that was hit
     **/
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        remainingBlocks.decrease(1);
    }

    /**
     * @return counter of blocks.
     **/
    public Counter getCounter() {
        return this.remainingBlocks;
    }

}