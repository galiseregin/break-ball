//322060187

import asssix.LevelInformation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import asssix.GameFlow;
import asssix.ThirdLevel;
import asssix.SecondLevel;
import asssix.ForthLevel;
import asssix.FirstLevel;
import asssix.AnimationRunner;
import java.util.ArrayList;
import java.util.List;

/**
 * main of the game.
 */
public class Ass6Game {
    /**
     * @param args -the main of the game use the initialize and run to play
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanold", 800, 600);
        KeyboardSensor key = gui.getKeyboardSensor();
        List<LevelInformation> informations = new ArrayList<>();
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "1":
                        LevelInformation levelInformation1 = new FirstLevel();
                        informations.add(levelInformation1);
                        break;
                    case "2":
                        LevelInformation levelInformation2 = new SecondLevel();
                        informations.add(levelInformation2);
                        break;
                    case "3":
                        LevelInformation levelInformation3 = new ThirdLevel();
                        informations.add(levelInformation3);
                        break;
                    case "4":
                        LevelInformation levelInformation4 = new ForthLevel();
                        informations.add(levelInformation4);
                        break;
                    default:
                        break;
                }

            }
        } else {
            LevelInformation levelInformation1 = new FirstLevel();
            informations.add(levelInformation1);
            LevelInformation levelInformation2 = new SecondLevel();
            LevelInformation levelInformation3 = new ThirdLevel();
            LevelInformation levelInformation4 = new ForthLevel();
            informations.add(levelInformation2);
            informations.add(levelInformation3);
            informations.add(levelInformation4);

        }

        AnimationRunner runner = new AnimationRunner(gui);
        GameFlow gameFlow = new GameFlow(runner, key, gui);
        gameFlow.runLevels(informations);
    }
}