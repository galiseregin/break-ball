//322060187
package asssix;

import assthree.SpriteCollection;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;
/**
 * making 3 2 1 .
 */
public class CountdownAnimation implements Animation {
    private SpriteCollection gameScreen;
    private double numOfSeconds;
    private int countFrom;
    private boolean stop;
    private Sleeper sleeper;
    private int saveCountFrom;
    private Long timeLeft;

    /**
     * @param numOfSeconds - to run
     * @param countFrom - 3
     * @param gameScreen - draw to screen
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSeconds;
        this.sleeper = new Sleeper();
        this.saveCountFrom = countFrom;
        this.timeLeft = null;
    }

    /**
     * @param d - surface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (countFrom < 0) {
            this.stop = true;
        }

        gameScreen.drawAllOn(d);
        Color purple = new Color(217, 41, 152);
        d.setColor(purple);
        d.drawText(400, 300, String.valueOf(countFrom), 80);
        long l = 500 * (long) numOfSeconds / (saveCountFrom);
        sleeper.sleepFor(l);
        countFrom--;

    }

    /**
     * @return - when to stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
