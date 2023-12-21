package com.haibin.leetcode.简单;

/**
 * @program: leetcode 1
 * @ClassName 两数之和
 * @description:
 * @author: haibin
 * @create: 2022-12-11 19:35
 * @Version 1.0
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
