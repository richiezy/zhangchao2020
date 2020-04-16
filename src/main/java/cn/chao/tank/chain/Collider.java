package cn.chao.tank.chain;

import cn.chao.tank.facade.GameObject;

public interface Collider {

    boolean collide(GameObject o1,GameObject o2);
}
