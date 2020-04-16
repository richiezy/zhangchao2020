package cn.chao.tank.facade;

import cn.chao.tank.Dir;
import cn.chao.tank.Group;
import cn.chao.tank.PropertyMgr;
import cn.chao.tank.Tank;
import cn.chao.tank.abstractfactory.*;
import cn.chao.tank.chain.Collider;
import cn.chao.tank.chain.ColliderChain;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GameModel {

    private static final GameModel INSTANCE = new GameModel();
    public List<GameObject> gos = new LinkedList<>();
    ColliderChain chains = new ColliderChain();

    private GameModel() {
        myTank = factory.createTank(200, 400, Dir.DOWN, Group.GOOD);
        int initCount = Integer.parseInt(PropertyMgr.get("initTankCount"));
        for (int i = 0; i < initCount; i++) {
            add(new Tank(100 + i * 70, 100 + i * 70, Dir.DOWN, Group.BAD));
        }
    }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    BaseTank myTank;
    public GameFactory factory = new DefaultFactory();

    public void add(GameObject go) {
        this.gos.add(go);
    }

    public void remove(GameObject go) {
        this.gos.remove(go);
    }


    public BaseTank getMainTank() {
        return myTank;
    }


    public void paint(Graphics g) {

        myTank.paint(g);

        for (int i = 0; i < gos.size(); i++) {
            gos.get(i).paint(g);
        }

        for (int i = 0; i < gos.size() - 1; i++) {
            for (int j = 1; j < gos.size(); j++) {
                chains.collide(gos.get(i), gos.get(j));
            }

        }

    }


}
