//32206087
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
 * second level.
 */
public class SecondLevel implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        Velocity v1 = new Velocity(1, -3);
        velocities.add(v1);
        Velocity v2 = new Velocity(-1, -3);
        velocities.add(v2);
        Velocity v3 = new Velocity(2, -2.7);
        velocities.add(v3);
        Velocity v4 = new Velocity(-2, -2.7);
        velocities.add(v4);
        Velocity v5 = new Velocity(3, -2.5);
        velocities.add(v5);
        Velocity v6 = new Velocity(-3, -2.5);
        velocities.add(v6);
        Velocity v7 = new Velocity(4, -2.3);
        velocities.add(v7);
        Velocity v8 = new Velocity(-4, -2.3);
        velocities.add(v8);
        Velocity v9 = new Velocity(5, -2.1);
        velocities.add(v9);
        Velocity v10 = new Velocity(-5, -2.1);
        velocities.add(v10);
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
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                d.drawText(590, 20, "Level Name:" + levelName(), 20);
                d.setColor(Color.white);
                d.fillRectangle(20, 40, 760, 600);
                Color c1 = new Color(255, 245, 143);
                d.setColor(c1);
                int k = 20;
                for (int i = 0; i < 75; i++) {
                    d.drawLine(150, 150, k, 250);
                    k = k + 10;
                }
                d.setColor(c1);
                d.fillCircle(150, 150, 50);
                d.setColor(Color.yellow);
                d.fillCircle(150, 150, 45);
                d.setColor(Color.ORANGE);
                d.fillCircle(150, 150, 40);
            }

            @Override
            public void timePassed() {

            }
        };
    }

    @Override
    public List<Block> blocks() {

        List<Block> blocks = new ArrayList<>();
        assthree.Point p1 = new assthree.Point(20, 250);
        assthree.Rectangle r1 = new Rectangle(p1, 50, 20);
        Block b1 = new Block(r1, Color.RED);
        blocks.add(b1);

        assthree.Point p2 = new assthree.Point(70, 250);
        assthree.Rectangle r2 = new Rectangle(p2, 50, 20);
        Block b2 = new Block(r2, Color.RED);
        blocks.add(b2);

        assthree.Point p3 = new assthree.Point(120, 250);
        assthree.Rectangle r3 = new Rectangle(p3, 50, 20);
        Block b3 = new Block(r3, Color.orange);
        blocks.add(b3);

        assthree.Point p4 = new assthree.Point(170, 250);
        assthree.Rectangle r4 = new Rectangle(p4, 50, 20);
        Block b4 = new Block(r4, Color.orange);
        blocks.add(b4);

        assthree.Point p5 = new assthree.Point(220, 250);
        assthree.Rectangle r5 = new Rectangle(p5, 50, 20);
        Block b5 = new Block(r5, Color.yellow);
        blocks.add(b5);

        assthree.Point p6 = new assthree.Point(270, 250);
        assthree.Rectangle r6 = new Rectangle(p6, 50, 20);
        Block b6 = new Block(r6, Color.yellow);
        blocks.add(b6);

        assthree.Point p7 = new assthree.Point(320, 250);
        assthree.Rectangle r7 = new Rectangle(p7, 50, 20);
        Block b7 = new Block(r7, Color.green);
        blocks.add(b7);

        assthree.Point p8 = new assthree.Point(370, 250);
        assthree.Rectangle r8 = new Rectangle(p8, 50, 20);
        Block b8 = new Block(r8, Color.green);
        blocks.add(b8);

        assthree.Point p9 = new assthree.Point(420, 250);
        assthree.Rectangle r9 = new Rectangle(p9, 50, 20);
        Block b9 = new Block(r9, Color.green);
        blocks.add(b9);

        assthree.Point p10 = new assthree.Point(470, 250);
        assthree.Rectangle r10 = new Rectangle(p10, 50, 20);
        Block b10 = new Block(r10, Color.blue);
        blocks.add(b10);

        assthree.Point p11 = new assthree.Point(520, 250);
        assthree.Rectangle r11 = new Rectangle(p11, 50, 20);
        Block b11 = new Block(r11, Color.blue);
        blocks.add(b11);

        assthree.Point p12 = new assthree.Point(570, 250);
        assthree.Rectangle r12 = new Rectangle(p12, 50, 20);
        Block b12 = new Block(r12, Color.pink);
        blocks.add(b12);

        assthree.Point p13 = new assthree.Point(620, 250);
        assthree.Rectangle r13 = new Rectangle(p13, 50, 20);
        Block b13 = new Block(r13, Color.pink);
        blocks.add(b13);

        assthree.Point p14 = new assthree.Point(670, 250);
        assthree.Rectangle r14 = new Rectangle(p14, 50, 20);
        Block b14 = new Block(r14, Color.cyan);
        blocks.add(b14);

        assthree.Point p15 = new assthree.Point(720, 250);
        assthree.Rectangle r15 = new Rectangle(p15, 60, 20);
        Block b15 = new Block(r15, Color.cyan);
        blocks.add(b15);


        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
