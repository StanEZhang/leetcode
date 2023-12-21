package com.haibin.leetcode.简单;

/**
 * @program: leetcode
 * @ClassName 存在重复元素
 * @description:
 * @author: haibin
 * @create: 2023-01-06 16:38
 * @Version 1.0
 */
public class 存在重复元素 {

    public boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = i + 1; j < nums.length - i; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;


    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        存在重复元素 存在重复元素 = new 存在重复元素();
        System.out.println(存在重复元素.containsDuplicate(nums));
    }

}
