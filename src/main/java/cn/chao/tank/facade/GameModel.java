package cn.chao.tank.facade;

import cn.chao.tank.Dir;
import cn.chao.tank.Group;
import cn.chao.tank.PropertyMgr;
import cn.chao.tank.Tank;
import cn.chao.tank.abstractfactory.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private static final GameModel INSTANCE = new GameModel();

    private GameModel() {
        myTank = factory.createTank(200, 400, Dir.DOWN, Group.GOOD);
        int initCount = Integer.parseInt(PropertyMgr.get("initTankCount"));
        for (int i = 0; i < initCount; i++) {
            tanks.add(new Tank(100 + i * 50, 100 + i * 50, Dir.DOWN, Group.BAD));
        }
    }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    BaseTank myTank;
    public GameFactory factory = new DefaultFactory();

    public java.util.List<BaseTank> tanks = new ArrayList<>();
    public List<BaseExplode> explodes = new ArrayList<>();
    public List<BaseBullet> bullets = new ArrayList<>();


    public BaseTank getMainTank() {
        return myTank;
    }


    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawString("子弹的数量为:" + bullets.size(), 10, 60);
        g.drawString("敌人的数量为:" + tanks.size(), 10, 90);

        g.drawString("爆炸的数量为:" + explodes.size(), 10, 120);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }


        for (int i = 0; i < bullets.size(); i++) {
            for (int l = 0; l < tanks.size(); l++) {

                bullets.get(i).collideWith(tanks.get(l));
            }
        }


    }


}
