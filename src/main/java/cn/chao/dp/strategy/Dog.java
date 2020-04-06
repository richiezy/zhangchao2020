package cn.chao.dp.strategy;

public class Dog implements Comparable<Dog> {
    int food;

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog o) {

        Dog d = (Dog) o;
        if (this.food < d.food) return -1;
        else if (this.food == d.food) return 0;
        return 1;
    }
}
