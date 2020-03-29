package cn.chao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
       int [] arr =  twoSum(nums,6);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
    public static int[] twoSum(int[] nums,int target){
        if(nums == null || nums.length < 0)
            throw new IllegalArgumentException();
        int [] resultArr = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            if(map.containsKey(target - nums[i])&& i!= map.get(target - nums[i])){

                resultArr[0] = i;
                resultArr[1] = map.get(target - nums[i]);
                return  resultArr;
            }

        }

        return  null;
    }

}
