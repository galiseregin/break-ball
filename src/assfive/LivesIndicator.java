//322060187
package assfive;

import assthree.GameLevel;
import assthree.Sprite;
import biuoop.DrawSurface;

/**
 * lives indicator.
 */
public class LivesIndicator implements Sprite {
    private Counter lives;

    /**
     * @param lives score
     */
    public LivesIndicator(Counter lives) {
        this.lives = lives;
    }

    /**
     * @param d - draw the sprite to the screen.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(10, 20, "Lives:" + this.lives.getValue(), 20);
    }
    @Override
    public void timePassed() {
        //empty for now
    }

    /**
     * decrease num of lives.
     */
    public void decrease() {
        lives.decrease(1);
    }

    /**
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * @return lives value
     */
    public int getLivesValue() {
        return this.lives.getValue();
    }
}
