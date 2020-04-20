package cn.chao.tank.chain;

import cn.chao.tank.Bullet;
import cn.chao.tank.Wall;
import cn.chao.tank.abstractfactory.BaseBullet;
import cn.chao.tank.abstractfactory.BaseWall;
import cn.chao.tank.facade.GameObject;

public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof BaseWall) {

            BaseBullet b = (BaseBullet) o1;
            BaseWall w = (BaseWall) o2;
            if (b.getRectangle().intersects(w.rect)) {
                System.out.println("---");
                b.die();
            }
        } else if (o1 instanceof BaseWall && o2 instanceof BaseBullet) {
            return collide(o2, o1);
        }

        return true;
    }
}
