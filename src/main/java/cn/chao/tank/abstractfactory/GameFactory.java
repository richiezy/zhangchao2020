package cn.chao.tank.abstractfactory;

import cn.chao.tank.Dir;
import cn.chao.tank.Group;
import cn.chao.tank.TankFrame;

public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group);

    public abstract BaseExplode createExplode(int x, int y);

}
