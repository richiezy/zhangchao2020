package cn.chao.dp.factory;

public class CarFactory {

    public Movable create(){
        System.out.println("create car");
        return  new Car();
    }
}
