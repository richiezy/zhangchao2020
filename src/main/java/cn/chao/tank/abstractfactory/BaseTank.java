package cn.chao.tank.abstractfactory;

import cn.chao.tank.*;
import cn.chao.tank.facade.GameModel;
import cn.chao.tank.facade.GameObject;
import cn.chao.tank.strage.DefaultFirStategy;
import cn.chao.tank.strage.FireStrategy;

import java.awt.*;
import java.util.Random;

public abstract class BaseTank extends GameObject {
    protected int SPEED = 5;
    public boolean living = true;
    protected boolean moving = true;
    protected Dir dir = Dir.DOWN;
    private Random random = new Random();
    int oldX, oldY;
    public Rectangle getRect() {
        return rect;
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
        }
        switch (dir) {
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;

            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;

            default:
                break;

        }

        move();
    }

    public Group group = Group.BAD;
    protected Rectangle rect = new Rectangle();

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return this.group;
    }

    public abstract void fire(FireStrategy strategy);

    public void back() {
        x = oldX;
        y = oldY;
    }

    private void move() {
        oldX = x;
        oldY = y;
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
            this.fire(DefaultFirStategy.getInstance());
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }

        boundsCheckout();

        rect.x = x;
        rect.y = y;

    }

    protected void boundsCheckout() {
        if (this.x < 0) x = 0;
        if (this.y < 30) y = 30;
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH) x = TankFrame.GAME_WIDTH - Tank.WIDTH;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
    }

    protected void randomDir() {

        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void die() {
        this.living = false;
    }

}
