//322060187
package asssix;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * stop the running.
 */
public class KeyPressStoppableAnimation implements Animation {
    private Animation anime;
    private KeyboardSensor keyboard;
    private String key;
    private boolean stop;
    private boolean isAlreadyPressed = true;

    /**
     * @param animation animation
     * @param keyboard keyboard
     * @param key the key
     */
    public KeyPressStoppableAnimation(Animation animation, KeyboardSensor keyboard, String key) {
        this.anime = animation;
        this.keyboard = keyboard;
        this.key = key;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed(key)) {
            if (!isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            isAlreadyPressed = false;
        }
        this.anime.doOneFrame(d);
    }

    @Override
    public boolean shouldStop() {
        return (anime.shouldStop() || this.stop);
    }
}
