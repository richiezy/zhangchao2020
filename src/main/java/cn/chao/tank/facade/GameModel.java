package cn.chao.tank.facade;

import cn.chao.tank.*;
import cn.chao.tank.abstractfactory.*;
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
        add(myTank);
        int initCount = Integer.parseInt(PropertyMgr.get("initTankCount"));
        for (int i = 0; i < initCount; i++) {
            add(factory.createTank(100 + i * 100, 200, Dir.DOWN, Group.BAD));
        }

        // 初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
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

        for (int i = 0; i < gos.size(); i++) {
            gos.get(i).paint(g);
        }

        for (int i = 0; i < gos.size() - 1; i++) {
            for (int j = i+1; j < gos.size(); j++) {
                chains.collide(gos.get(i), gos.get(j));
            }

        }

    }


}
