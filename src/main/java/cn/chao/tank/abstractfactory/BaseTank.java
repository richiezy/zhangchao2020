package cn.chao.tank.abstractfactory;

import cn.chao.tank.Dir;
import cn.chao.tank.facade.GameObject;
import cn.chao.tank.strage.FireStrategy;
import cn.chao.tank.Group;
import cn.chao.tank.TankFrame;

import java.awt.*;

public abstract class BaseTank extends GameObject {
    public boolean living = true;
    protected boolean moving = true;
    protected Dir dir = Dir.DOWN;

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Group group = Group.BAD;
    protected Rectangle rect = new Rectangle();

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }


    public Group getGroup() {
        return this.group;
    }

    public abstract void die();

    public abstract void fire(FireStrategy strategy);
}
