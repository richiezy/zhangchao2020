package cn.chao.tank.chain;

import cn.chao.tank.Tank;
import cn.chao.tank.Wall;
import cn.chao.tank.abstractfactory.BaseTank;
import cn.chao.tank.abstractfactory.BaseWall;
import cn.chao.tank.facade.GameObject;

public class TankWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof BaseTank && o2 instanceof BaseWall) {
            BaseTank t = (BaseTank)o1;
            BaseWall w = (BaseWall)o2;


            if(t.getRect().intersects(w.rect)) {
                t.back();
            }

        } else if (o1 instanceof Wall && o2 instanceof BaseTank) {
            return collide(o2, o1);
        }

        return true;

    }
}