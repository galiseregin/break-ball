//ID: 322060187
package assthree;

import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * class creating spirits collection notify and draw all spirits.
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprites;

    /**
     * func create sprites array.
     */
    public SpriteCollection() {
        sprites = new ArrayList<Sprite>();
    }

    /**
     * @param s -add  sprite to collection.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * @param s -remove  sprite to collection.
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.sprites.size(); i++) {
            this.sprites.get(i).timePassed();
        }
    }

    /**
     * @param d -call drawOn(d) on all sprites.
     */

    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}
