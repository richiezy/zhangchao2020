package cn.chao.dp.factory;

public class Main {

    public static void main(String[] args) {
        Movable movable = new CarFactory().create();
        movable.go();
    }
}
