package cn.chao.tank;

import cn.chao.tank.abstractfactory.BaseExplode;

import java.awt.*;

public class Explode extends BaseExplode {

    public static final int WIDTH = ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();
    protected int x, y;
    protected TankFrame tankFrame;


    protected int step = 0;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            tankFrame.explodes.remove(this);
    }


}
