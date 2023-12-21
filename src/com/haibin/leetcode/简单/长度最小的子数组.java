package com.haibin.leetcode.简单;

/**
 * @program: leetcode
 * @ClassName 长度最小的子数组
 * @description:
 * @author: haibin
 * @create: 2023-01-08 17:50
 * @Version 1.0
 */
public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = 100000;
        int i;
        int j;
        for(i = 0; i <nums.length; i++){
            int sum = 0;
            for(j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == target){
                    len = j -i + 1 < len ? j -i + 1 : len ;
                }else if(sum > target){
                    break;
                }
            }
        }
        return len == 100000 ? 0 : len;
    }
    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = nums[left];
        int len = 100000;
        while(right < nums.length-1){
            if(sum <target){
                right++;
                sum += nums[right];
            }else{
                len = right -left + 1 < len ? right - left + 1 : len;
                sum -= nums[left];
                left++;
            }
        }
        return len == 100000 ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        长度最小的子数组 长度最小的子数组 = new 长度最小的子数组();
        int i = 长度最小的子数组.minSubArrayLen2(7, nums);
        System.out.println(i);
    }
}
