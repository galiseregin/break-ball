//322060187
package asssix;

import assthree.Block;
import assthree.Sprite;
import assthree.Velocity;

import java.util.List;

/**
 * interface of info about current level.
 */
public interface LevelInformation {
    /**
     * @return num of balls
     */
    int numberOfBalls();

    /**
     * @return The initial velocity of each ball
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return Speed of paddle
     */
    int paddleSpeed();

    /**
     * @return width
     */
    int paddleWidth();

    /**
     * @return the level name will be displayed at the top of the screen.
     */
    String levelName();

    /**
     * @return  a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * @return The Blocks that make up this level, each block contains its size, color and location.
     */

    List<Block> blocks();

    /**
     * @return Number of blocks that should be removed before the level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();
}
