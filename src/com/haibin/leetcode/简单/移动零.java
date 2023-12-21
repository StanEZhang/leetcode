package com.haibin.leetcode.简单;

import java.util.Arrays;

/**
 * @project: leetcode
 * @className: 移动零
 * @description:
 * @author: zhanghaibin
 * @create: 2023-06-28
 */
public class 移动零 {

    /**
     输入: nums = [0,1,0,3,12]
     输出: [1,3,12,0,0]
     */
    public int[] moveZeroes(int[] nums) {

        // 记录有几个非零
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[count] = nums[i];
                count++;
            }
        }

        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        移动零 移动零 = new 移动零();
        int[] ints = 移动零.moveZeroes(nums);
        System.out.println(Arrays.toString(ints));
    }
}
