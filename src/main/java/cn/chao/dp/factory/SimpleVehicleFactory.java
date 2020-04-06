package cn.chao.dp.factory;

public class SimpleVehicleFactory {

    public Car createCar(){
        return  new Car();
    }

    public Plane createPlane(){

        return  new Plane();
    }
}
