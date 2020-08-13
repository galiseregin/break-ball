//ID: 322060187
package assthree;

import assfive.Counter;
import assfive.LivesIndicator;
import assfive.BallRemover;
import assfive.ScoreTrackingListener;
import assfive.ScoreIndicator;
import assfive.BlockRemover;
import asssix.Animation;
import asssix.AnimationRunner;
import asssix.KeyPressStoppableAnimation;
import asssix.LevelInformation;
import asssix.CountdownAnimation;
import asssix.PauseScreen;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.List;

/**
 * adding spirit collides blocks in the screen the paddle ,ball and screen.
 */
public class GameLevel implements Animation {
    private LivesIndicator live;
    private Counter score;
    private GUI gui;
    private BlockRemover br;
    private BallRemover ballr;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    private Counter blockCounter;
    private Counter ballsCounter;


    /**
     * constructor.
     * @param s counter
     * @param key the keyboard key
     * @param levelInformation info on level
     * @param livesIndicator  is there lives
     * @param runner runner
     * @param gui gui
     */
    public GameLevel(GUI gui, LevelInformation levelInformation, KeyboardSensor key, AnimationRunner runner,
                     LivesIndicator livesIndicator, Counter s) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.runner = runner;
        this.gui = gui;
        this.keyboard = this.gui.getKeyboardSensor();
        this.live = livesIndicator;
        this.levelInformation = levelInformation;
        this.score = s;
    }


    /**
     * @param c -adding collide to the environment
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * @param s -adding spirit to the spirit's
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * @return num of blocks
     */
    public Counter getBlockCounter() {
        return blockCounter;
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        // gui = new GUI("Game", 800, 600);
        this.blockCounter = new Counter(this.levelInformation.numberOfBlocksToRemove());
        this.br = new BlockRemover(this, this.blockCounter);

        this.ballsCounter = new Counter(0);
        this.ballr = new BallRemover(this, ballsCounter);
        ScoreIndicator sco = new ScoreIndicator(score);
        ScoreTrackingListener st = new ScoreTrackingListener(score);


        Sleeper sleeper = new Sleeper();
        //right
        Point p1 = new Point(780, 20);
        Rectangle r1 = new Rectangle(p1, 20, 800);
        Block b1 = new Block(r1, Color.GRAY);
        b1.addToGame(this);
        //left
        Point p2 = new Point(0, 20);
        Rectangle r2 = new Rectangle(p2, 20, 800);
        Block b2 = new Block(r2, Color.GRAY);
        b2.addToGame(this);
        //up
        Point p3 = new Point(0, 20);
        Rectangle r3 = new Rectangle(p3, 800, 20);
        Block b3 = new Block(r3, Color.GRAY);
        b3.addToGame(this);
        //down
        Point p4 = new Point(0, 599);
        Rectangle r4 = new Rectangle(p4, 800, 1);
        Block b4 = new Block(r4, Color.gray);
        b4.addToGame(this);
        b4.addHitListener(ballr);
        ScoreIndicator s = new ScoreIndicator(score);
        s.addToGame(this);
        //first row
        int x = 730;
        int y = 90;
        addSprite(this.levelInformation.getBackground());
        List<Block> blocks = levelInformation.blocks();
        for (int i = 0; i < this.levelInformation.numberOfBlocksToRemove(); i++) {
            blocks.get(i).addHitListener(br);
            blocks.get(i).addHitListener(st);
            blocks.get(i).addToGame(this);
        }
        live.addToGame(this);

        //paddle
        Point p6 = new Point(350, 560);
        int width = this.levelInformation.paddleWidth();
        int speed = this.levelInformation.paddleSpeed();
        Rectangle r6 = new Rectangle(p6, width, 20);
        Block b6 = new Block(r6, Color.YELLOW);
        Paddle paddle = new Paddle(r6, gui, Color.yellow);
        paddle.addToGame(this);
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void addBalls() {
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Velocity v = levelInformation.initialBallVelocities().get(i);
            Color pink = new Color(217, 53, 93);
            Ball ball1 = new Ball(400, 555, 5, pink);
            ball1.setVelocity(v.getDx(), v.getDy());
            ball1.setGameEnvironment(this.environment);
            ball1.addToGame(this);

        }

        ballsCounter.increase(this.levelInformation.numberOfBalls());

    }

    /**
     * what happens in each turn.
     */
    public void playOneTurn() {
        addBalls();
        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3, sprites));
        this.runner.run(this);

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(
                    new PauseScreen(this.keyboard), keyboard, keyboard.SPACE_KEY));
        }


        if (ballr.getCounter().getValue() <= 0) {
            live.decrease();
            this.running = false;

        }
        if (this.br.getCounter().getValue() <= 0) {
            this.running = false;
        }
        this.sprites.notifyAllTimePassed();
        this.sprites.drawAllOn(d);

    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * @param c -remove c
     **/
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * @param s -remove s
     **/
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }
}


