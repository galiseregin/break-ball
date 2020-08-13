//322060187
package asssix;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * pause screen.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * @param k sensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * @param d - surface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * @return when to stop
     */
    public boolean shouldStop() {
        return this.stop;
    }
}