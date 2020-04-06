package cn.chao.dp.strategy;

public class Main {

    public static void main(String[] args) {
//        int[] arr = {9,4,5,3,6,7,1};
//        Cat[] arr = {new Cat(3,5),new Cat(2,4),new Cat(1,6)};
        Dog[] arr1 = {new Dog(5),new Dog(7),new Dog(3)};
        Sorter <Dog>sorter = new Sorter<>();
        DogComparator comparator = new DogComparator();
        sorter.sort(arr1 ,comparator);
        sorter.printArr(arr1);
    }
}
