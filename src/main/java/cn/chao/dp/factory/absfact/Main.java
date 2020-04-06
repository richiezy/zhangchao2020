package cn.chao.dp.factory.absfact;


public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.go();
        Knife knife = new Knife();
        knife.attack();
        Bread b = new Bread();
        b.printName();
    }
}
