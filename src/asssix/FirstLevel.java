//322060187
package asssix;

import assthree.Block;
import assthree.Rectangle;
import assthree.Sprite;
import assthree.Velocity;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the first level.
 */
public class FirstLevel implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        Velocity v = new Velocity(0.00001, -5);
        velocities.add(v);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                d.drawText(590, 20, "Level Name:" + levelName(), 20);
                d.setColor(Color.black);
                d.fillRectangle(20, 40, 760, 600);
                d.setColor(Color.blue);
                d.drawLine(260, 160, 380, 160);
                d.drawLine(541, 160, 419, 160);
                d.drawLine(400, 40, 400, 142);
                d.drawLine(400, 180, 400, 300);

                d.drawCircle(400, 160, 120);
                d.drawCircle(400, 160, 90);
                d.drawCircle(400, 160, 60);
            }

            @Override
            public void timePassed() {

            }
        };
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        assthree.Point p1 = new assthree.Point(385, 147);
        assthree.Rectangle r1 = new Rectangle(p1, 30, 30);
        Block b1 = new Block(r1, Color.RED);
        blocks.add(b1);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
