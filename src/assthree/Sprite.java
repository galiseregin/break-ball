//322060187
package assthree;

import biuoop.DrawSurface;

/**
 * interface of spirits.
 */
public interface Sprite {
    /**
     * @param d - draw the sprite to the screen.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
