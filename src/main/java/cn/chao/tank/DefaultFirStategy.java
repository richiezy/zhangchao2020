package cn.chao.tank;

import cn.chao.tank.abstractfactory.BaseTank;

public class DefaultFirStategy implements FireStrategy {

    private static DefaultFirStategy INSTANCE = new DefaultFirStategy();

    private DefaultFirStategy() {
    }

    public static DefaultFirStategy getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(BaseTank tank) {
        int bx = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tank.getTf().getFactory().createBullet(bx, by, tank.getDir(), tank.getGroup(), tank.getTf());
//        new Bullet(bx, by, tank.getDir(), tank.getGroup(), tank.getTf());
    }
}
