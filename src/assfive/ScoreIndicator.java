//322060187
package assfive;

import assthree.GameLevel;
import assthree.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * check the score of the game.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * @param score score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * @param d - draw the sprite to the screen.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawRectangle(0, 0, 800, 20);
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.BLACK);
        d.drawText(380, 20, "Score:" + this.score.getValue(), 20);
    }

    @Override
    public void timePassed() {
        //empty for now
    }

    /**
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

}
