package cn.chao.leetcode;

public class GetLeastNums {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4, 6, 8};
        int[] result = getLeastNums(arr, 3);

    }

    private static int[] getLeastNums(int[] arr, int i) {
        if (arr == null || arr.length < 0 || i < 0) {
            throw new IllegalArgumentException();
        }
        if (i > arr.length) return arr;


        /*快速排序*/
        sort(arr, 0, arr.length - 1);
        int[] resultArr = new int[i];
        for (int j = 0; j < i; j++) {
            resultArr[j] = arr[j];
        }


        return resultArr;
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = partition(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }

    private static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > pivot) right--;
            if (left < right) swap(arr, left, right);
        }
        swap(arr, left, rightBound);

        return left;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
