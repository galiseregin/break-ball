//322060187
package asssix;

import assfive.Counter;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * loose screen.
 */
public class LooseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;

    /**
     * @param score score
     * @param k sensor
     */
    public LooseScreen(Counter score, KeyboardSensor k) {
        this.score = score;
        this.keyboard = k;
    }

    /**
     * @param d - surface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over.Your Score is " + this.score.getValue(), 32);
    }

    /**
     * @return when to stop
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
