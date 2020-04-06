package cn.chao.dp.strategy;

public class Sorter<T> {

    public  void sort(T [] arr,Comparator<T> comparator){
        sort(arr,0,arr.length-1,comparator);

    }

    private  void sort(T[] arr, int left, int right,Comparator<T> comparator) {
        if (left >= right) return;
        int mid = partition(arr, left, right,comparator);
        sort(arr, left, mid - 1,comparator);
        sort(arr, mid + 1, right,comparator);
    }

    private  int partition(T[] arr, int leftBound, int rightBound,Comparator<T> comparator) {
        T pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            while (left <= right && comparator.compare(arr[left],pivot) <=0  ) left++;
            while (left <= right && comparator.compare(arr[left],pivot) >0 ) right--;
            if (left < right) swap(arr, left, right);
        }
        swap(arr, left, rightBound);

        return left;
    }

     void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArr(T[] arr){
        for (int l = 0; l <arr.length ; l++) {
            System.out.print(arr[l] + " " );

        }
        System.out.println();
    }
}
