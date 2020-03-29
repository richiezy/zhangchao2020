package cn.chao.tank;

import java.awt.*;
import java.util.Random;

/**
 * 抽象出坦克类,特别的属性和方法.
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    public static final int WIDTH = ResourceMgr.goodTankD.getWidth(), HEIGHT = ResourceMgr.goodTankD.getHeight();
    private boolean moving = true;
    private Random random = new Random();
    private TankFrame tf;
    private Group group;

    Rectangle rectangle = new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isMoving() {
        return moving;
    }

    public boolean living = true;

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.tanks.remove(this);
        }


        switch (dir) {
            case DOWN:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankD:ResourceMgr.badTankD, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankU:ResourceMgr.badTankU, x, y, null);
                break;
            case LEFT:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankL:ResourceMgr.badTankL, x, y, null);
                break;

            case RIGHT:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankR:ResourceMgr.badTankR, x, y, null);
                break;

            default:
                break;

        }

        move();
    }


    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;


        tf.lists.add(new Bullet(bx, by, this.dir, this.getGroup(), tf));
    }


    private void move() {
        if (!moving) return;

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }

        boundsCheckout();

        rectangle.x = x;
        rectangle.y = y;

    }

    private void boundsCheckout() {
        if(this.x<0) x = 0;
        if(this.y< 30) y = 30;
        if(this.x > TankFrame.GAME_WIDTH-Tank.WIDTH) x = TankFrame.GAME_WIDTH-Tank.WIDTH;
        if(this.y> TankFrame.GAME_HEIGHT-Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
    }

    private void randomDir() {

        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void die() {
        this.living = false;
    }
}

