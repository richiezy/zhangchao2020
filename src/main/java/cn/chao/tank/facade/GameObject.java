package cn.chao.tank.facade;

import java.awt.*;

public abstract  class GameObject {
    protected  int x, y;

    public abstract void paint(Graphics g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
