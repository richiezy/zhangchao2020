package cn.chao.tank.abstractfactory;

import cn.chao.tank.ResourceMgr;
import cn.chao.tank.TankFrame;
import cn.chao.tank.facade.GameObject;

import java.awt.*;

public abstract class BaseExplode extends GameObject {
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();

    protected int step = 0;

}
