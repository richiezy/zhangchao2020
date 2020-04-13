package cn.chao.tank;

import cn.chao.tank.abstractfactory.BaseExplode;
import cn.chao.tank.facade.GameModel;

import java.awt.*;

public class Explode extends BaseExplode {

    public static final int WIDTH = ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();
    protected int x, y;
    protected TankFrame tankFrame;


    protected int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            GameModel.getInstance().remove(this);
    }


}
