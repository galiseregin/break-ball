//322060187
package asssix;

import assfive.Counter;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * win screen.
 */
public class WinScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;

    /**
     * @param k sensor
     */
    public WinScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * @param score score
     * @param k sensor
     */
    public WinScreen(Counter score, KeyboardSensor k) {
        this.score = score;
        this.keyboard = k;
    }

    /**
     * @param d - surface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your Score is " + this.score.getValue(), 32);
    }

    /**
     * @return when to stop
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
