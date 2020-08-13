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
 * the 4th level.
 */
public class ForthLevel implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        Velocity v = new Velocity(0.0001, -5);
        velocities.add(v);

        Velocity v1 = new Velocity(5, -5);
        velocities.add(v1);

        Velocity v2 = new Velocity(-5, -5);
        velocities.add(v2);
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                d.drawText(590, 20, "Level Name:" + levelName(), 20);
                Color c1 = new Color(20, 161, 199);
                d.setColor(c1);
                d.fillRectangle(20, 40, 760, 600);


                Color c2 = new Color(153, 153, 153);
                Color c3 = new Color(136, 136, 136);
                Color c4 = new Color(204, 204, 204);
                //rain
                int j = 260;
                for (int i = 10; i > 0; i--) {
                    d.setColor(c4);
                    d.drawLine(j, 400, j - 20, 600);
                    j -= 10;
                }
//if it looks like a cloud and feels like a cloud its a cloud
                d.setColor(c4);
                d.fillCircle(170, 410, 20);
                d.fillCircle(190, 430, 25);
                d.setColor(c2);
                d.fillCircle(210, 400, 25);
                d.setColor(c3);
                d.fillCircle(250, 400, 30);
                d.fillCircle(230, 430, 20);

                int k = 710;
                for (int i = 10; i > 0; i--) {
                    d.setColor(c4);
                    d.drawLine(k, 500, k - 20, 600);
                    k -= 10;
                }
                d.setColor(c4);
                d.fillCircle(620, 510, 20);
                d.fillCircle(640, 530, 25);
                d.setColor(c2);
                d.fillCircle(660, 500, 25);
                d.setColor(c3);
                d.fillCircle(700, 500, 30);
                d.fillCircle(680, 530, 20);

                d.drawLine(260, 181, 380, 181);


            }

            @Override
            public void timePassed() {

            }
        };
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int x = 20;
        int y = 100;

        for (int i = 14; i > 0; i--) {
            assthree.Point p1 = new assthree.Point(x, y);
            assthree.Rectangle r1 = new Rectangle(p1, 50, 20);
            Block b1 = new Block(r1, Color.gray);
            blocks.add(b1);
            x += 50;
        }
        assthree.Point p = new assthree.Point(720, y);
        assthree.Rectangle r = new Rectangle(p, 60, 20);
        Block b = new Block(r, Color.gray);
        blocks.add(b);

        int x1 = 20;
        int y1 = 120;
        for (int i = 14; i > 0; i--) {
            assthree.Point p2 = new assthree.Point(x1, y1);
            assthree.Rectangle r2 = new Rectangle(p2, 50, 20);
            Block b2 = new Block(r2, Color.red);
            blocks.add(b2);
            x1 += 50;
        }
        assthree.Point p2 = new assthree.Point(720, y1);
        assthree.Rectangle r2 = new Rectangle(p2, 60, 20);
        Block b2 = new Block(r2, Color.red);
        blocks.add(b2);
        int x2 = 20;
        int y2 = 140;
        for (int i = 14; i > 0; i--) {
            assthree.Point p3 = new assthree.Point(x2, y2);
            assthree.Rectangle r3 = new Rectangle(p3, 50, 20);
            Block b3 = new Block(r3, Color.yellow);
            blocks.add(b3);
            x2 += 50;
        }
        assthree.Point p3 = new assthree.Point(720, y2);
        assthree.Rectangle r3 = new Rectangle(p3, 60, 20);
        Block b3 = new Block(r3, Color.yellow);
        blocks.add(b3);

        int x3 = 20;
        int y3 = 160;
        for (int i = 14; i > 0; i--) {
            assthree.Point p4 = new assthree.Point(x3, y3);
            assthree.Rectangle r4 = new Rectangle(p4, 50, 20);
            Block b4 = new Block(r4, Color.green);
            blocks.add(b4);
            x3 += 50;
        }
        assthree.Point p4 = new assthree.Point(720, y3);
        assthree.Rectangle r4 = new Rectangle(p4, 60, 20);
        Block b4 = new Block(r4, Color.green);
        blocks.add(b4);

        int x4 = 20;
        int y4 = 180;
        for (int i = 14; i > 0; i--) {
            assthree.Point p5 = new assthree.Point(x4, y4);
            assthree.Rectangle r5 = new Rectangle(p5, 50, 20);
            Block b5 = new Block(r5, Color.white);
            blocks.add(b5);
            x4 += 50;
        }

        assthree.Point p5 = new assthree.Point(720, y4);
        assthree.Rectangle r5 = new Rectangle(p5, 60, 20);
        Block b5 = new Block(r5, Color.white);
        blocks.add(b5);

        int x5 = 20;
        int y5 = 200;
        for (int i = 14; i > 0; i--) {
            assthree.Point p6 = new assthree.Point(x5, y5);
            assthree.Rectangle r6 = new Rectangle(p6, 50, 20);
            Block b6 = new Block(r6, Color.pink);
            blocks.add(b6);
            x5 += 50;
        }

        assthree.Point p6 = new assthree.Point(720, y5);
        assthree.Rectangle r6 = new Rectangle(p6, 60, 20);
        Block b6 = new Block(r6, Color.pink);
        blocks.add(b6);

        int x6 = 20;
        int y6 = 220;
        for (int i = 14; i > 0; i--) {
            assthree.Point p7 = new assthree.Point(x6, y6);
            assthree.Rectangle r7 = new Rectangle(p7, 50, 20);
            Block b7 = new Block(r7, Color.cyan);
            blocks.add(b7);
            x6 += 50;
        }

        assthree.Point p7 = new assthree.Point(720, y6);
        assthree.Rectangle r7 = new Rectangle(p7, 60, 20);
        Block b7 = new Block(r7, Color.cyan);
        blocks.add(b7);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
