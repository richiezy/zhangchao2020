package cn.chao.tank.chain;

import cn.chao.tank.Bullet;
import cn.chao.tank.Explode;
import cn.chao.tank.Tank;
import cn.chao.tank.abstractfactory.BaseBullet;
import cn.chao.tank.abstractfactory.BaseTank;
import cn.chao.tank.facade.GameModel;
import cn.chao.tank.facade.GameObject;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {


        if (o1 instanceof BaseBullet && o2 instanceof BaseTank) {
            BaseBullet b = (BaseBullet) o1;
            BaseTank t = (BaseTank) o2;
            //TODO copy code from method collideWith
            if (b.collideWith(t)) {
                return false;
            }

        } else if (o1 instanceof BaseTank && o2 instanceof BaseBullet) {
            return collide(o2, o1);
        }

        return true;

    }


    private boolean collideWith(BaseTank tank, BaseBullet bullet) {
        if (bullet.getGroup() == tank.getGroup()) return true;

        if (bullet.getRectangle().intersects(tank.getRect())) {
            tank.die();
            bullet.die();

            int ex = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int ey = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;

            GameModel.getInstance().add(GameModel.getInstance().factory.createExplode(ex, ey));
        }
        return false;
    }
}
