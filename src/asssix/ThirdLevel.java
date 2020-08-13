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
 * level 3.
 */
public class ThirdLevel implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        Velocity v = new Velocity(3, -5);
        Velocity v1 = new Velocity(-3, -5);
        velocities.add(v);
        velocities.add(v1);
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                d.drawText(590, 20, "Level Name:" + levelName(), 20);
                Color c1 = new Color(32, 154, 15);
                d.setColor(c1);
                d.fillRectangle(21, 41, 759, 600);

                d.setColor(Color.black);
                d.fillRectangle(50, 480, 80, 160);
                d.setColor(Color.DARK_GRAY);
                d.fillRectangle(78, 440, 25, 40);
                d.setColor(Color.DARK_GRAY);
                d.fillRectangle(87, 300, 7, 140);
                int x = 56;
                for (int i = 5; i > 0; i--) {
                    d.setColor(Color.white);
                    d.fillRectangle(x, 490, 8, 17);
                    x += 15;
                }
                int x1 = 56;
                for (int i = 5; i > 0; i--) {
                    d.setColor(Color.white);
                    d.fillRectangle(x1, 515, 8, 17);
                    x1 += 15;
                }
                int x2 = 56;
                for (int i = 5; i > 0; i--) {
                    d.setColor(Color.white);
                    d.fillRectangle(x2, 540, 8, 17);
                    x2 += 15;
                }
                int x3 = 56;
                for (int i = 5; i > 0; i--) {
                    d.setColor(Color.white);
                    d.fillRectangle(x3, 565, 8, 17);
                    x3 += 15;
                }
                int x4 = 56;
                for (int i = 5; i > 0; i--) {
                    d.setColor(Color.white);
                    d.fillRectangle(x4, 590, 8, 17);
                    x4 += 15;
                }
                Color c2 = new Color(199, 122, 25);
                d.setColor(c2);
                d.fillCircle(91, 295, 8);

                Color c3 = new Color(199, 75, 77);
                d.setColor(c3);

                d.fillCircle(91, 295, 6);
                d.setColor(Color.white);
                d.fillCircle(91, 295, 3);
            }

            @Override
            public void timePassed() {

            }
        };
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int x = 730;
        int y = 90;

        for (int i = 10; i > 0; i--) {
            assthree.Point p1 = new assthree.Point(x, y);
            assthree.Rectangle r1 = new Rectangle(p1, 50, 20);
            Block b1 = new Block(r1, Color.gray);
            blocks.add(b1);
            x -= 50;
        }
        int x1 = 730;
        int y1 = 110;
        for (int i = 9; i > 0; i--) {
            assthree.Point p2 = new assthree.Point(x1, y1);
            assthree.Rectangle r2 = new Rectangle(p2, 50, 20);
            Block b2 = new Block(r2, Color.red);
            blocks.add(b2);
            x1 -= 50;
        }
        int x2 = 730;
        int y2 = 130;
        for (int i = 8; i > 0; i--) {
            assthree.Point p3 = new assthree.Point(x2, y2);
            assthree.Rectangle r3 = new Rectangle(p3, 50, 20);
            Block b2 = new Block(r3, Color.yellow);
            blocks.add(b2);
            x2 -= 50;
        }
        int x3 = 730;
        int y3 = 150;
        for (int i = 7; i > 0; i--) {
            assthree.Point p4 = new assthree.Point(x3, y3);
            assthree.Rectangle r4 = new Rectangle(p4, 50, 20);
            Block b4 = new Block(r4, Color.blue);
            blocks.add(b4);
            x3 -= 50;
        }
        int x4 = 730;
        int y4 = 170;
        for (int i = 6; i > 0; i--) {
            assthree.Point p5 = new assthree.Point(x4, y4);
            assthree.Rectangle r5 = new Rectangle(p5, 50, 20);
            Block b5 = new Block(r5, Color.white);
            blocks.add(b5);
            x4 -= 50;
        }

        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
