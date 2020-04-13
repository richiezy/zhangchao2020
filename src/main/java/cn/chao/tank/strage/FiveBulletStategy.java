package cn.chao.tank.strage;

import cn.chao.tank.Bullet;
import cn.chao.tank.Dir;
import cn.chao.tank.Tank;
import cn.chao.tank.abstractfactory.BaseTank;
import cn.chao.tank.facade.GameModel;

public class FiveBulletStategy implements FireStrategy {
  /*  public List<Bullet> getBullet(Tank tank) {
        List<Bullet> bullets = new ArrayList<>();
        int bx = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        for (int i = 0; i < 5; i++) {

            bullets.add(new Bullet(bx, by, tank.getDir(), tank.getGroup(), tank.getTf()));
        }

        return bullets;
    }*/

    @Override
    public void fire(BaseTank tank) {
        int bx = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Dir[] values = Dir.values();
        for (Dir dir : values
        ) {
            GameModel.getInstance().factory.createBullet(bx, by, dir, tank.getGroup());
//            new Bullet(bx, by, dir, tank.getGroup(), tank.getTf());
        }

    }
}
