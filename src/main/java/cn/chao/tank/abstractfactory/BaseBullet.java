package cn.chao.tank.abstractfactory;

import cn.chao.tank.facade.GameObject;


public abstract class BaseBullet extends GameObject {

    public abstract void collideWith(BaseTank tank);
}
