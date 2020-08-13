//322060187
package asssix;

import assfive.Counter;
import assfive.LivesIndicator;
import assthree.GameLevel;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * game flow.
 */
public class GameFlow {

    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private LivesIndicator live;
    private GUI gui;
    private Counter score;

    /**
     * @param ar - animation runner
     * @param ks - sensor
     * @param gui - gui
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui;
        this.score = new Counter(0);
        this.live = new LivesIndicator(new Counter(7));

    }

    /**
     * @param levels - levels of the game
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean isThereStillLife = true;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(this.gui, levelInfo,
                    this.keyboardSensor, this.animationRunner, this.live, this.score);
            level.initialize();


            while (level.getBlockCounter().getValue() > 0 && live.getLivesValue() != 0) {
                level.playOneTurn();
            }

            if (live.getLivesValue() == 0) {
                isThereStillLife = false;
                break;
            }
            if (level.getBlockCounter().getValue() == 0) {
                this.score.increase(100);
            }
        }
        if (isThereStillLife) {
            WinScreen winScreen = new WinScreen(this.score, keyboardSensor);
            this.animationRunner.run(new KeyPressStoppableAnimation(winScreen,
                    this.keyboardSensor, keyboardSensor.SPACE_KEY));
            //winScreem
        } else {
            LooseScreen looseScreen = new LooseScreen(this.score, keyboardSensor);
            this.animationRunner.run(new KeyPressStoppableAnimation(looseScreen,
                    this.keyboardSensor, keyboardSensor.SPACE_KEY));

            //gameoverscreen
        }
        gui.close();

    }
}
