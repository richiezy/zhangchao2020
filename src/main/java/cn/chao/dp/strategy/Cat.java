package cn.chao.dp.strategy;

import cn.chao.thread.sync.T;

public class Cat implements Comparable<Cat> {

    private Integer height;
    private Integer weight;

    public Cat(Integer height, Integer weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


    @Override
    public int compareTo(Cat o) {

        if (this.weight > o.weight) return 1;
        else if (this.weight < o.weight) return -1;
        return 0;
    }
}
