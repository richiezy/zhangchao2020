package cn.chao.tank;

import cn.chao.tank.abstractfactory.BaseTank;
import cn.chao.tank.facade.GameModel;
import cn.chao.tank.strage.DefaultFirStategy;
import cn.chao.tank.strage.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * 抽象出坦克类,特别的属性和方法.
 */
public class Tank extends BaseTank {
    public static final int WIDTH = ResourceMgr.goodTankD.getWidth(), HEIGHT = ResourceMgr.goodTankD.getHeight();

    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }


    public void fire(FireStrategy strategy) {
        strategy.fire(this);
    }






}

