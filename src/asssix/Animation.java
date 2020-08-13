//322060187
package asssix;

import biuoop.DrawSurface;

/**
 * animation .
 */
public interface Animation {
    /**
     * @param d - surface
     */
    void doOneFrame(DrawSurface d);

    /**
     * @return if stop
     */
    boolean shouldStop();
}
