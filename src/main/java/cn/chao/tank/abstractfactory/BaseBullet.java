package cn.chao.tank.abstractfactory;

import cn.chao.tank.Group;
import cn.chao.tank.facade.GameObject;

import java.awt.*;


public abstract class BaseBullet extends GameObject {
    protected Group group;
    protected boolean living = true;
    protected Rectangle rectangle = new Rectangle();

    public Rectangle getRectangle() {
        return rectangle;
    }

    public abstract boolean collideWith(BaseTank tank);

    public Group getGroup() {
        return group;
    }

    public void die() {
        this.living = false;
    }
}
