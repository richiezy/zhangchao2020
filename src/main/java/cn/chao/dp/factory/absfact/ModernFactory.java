package cn.chao.dp.factory.absfact;

public class ModernFactory extends  AbstractFactory {
    @Override
    Food creatFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new Knife();
    }
}
