package cn.chao.tank.abstractfactory;

import cn.chao.tank.ResourceMgr;
import cn.chao.tank.TankFrame;

import java.awt.*;

public abstract class BaseExplode {
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();
    protected int x, y;
    protected TankFrame tankFrame;


    protected int step = 0;

    public abstract void paint(Graphics g);
}
