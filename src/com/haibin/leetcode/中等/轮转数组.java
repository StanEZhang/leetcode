package com.haibin.leetcode.中等;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @project: leetcode
 * @className: 轮转数组
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-06
 */
public class 轮转数组 {
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(ans, 0, nums, 0, nums.length);

        /**
         * 以下不能修改rotate方法外的nums的引用，因为传入方法内的是nums的一个地址副本，这个地址和
         * 原始地址一样指向同一个数组，所以你修改了方法内的nums的引用，不能修改到方法外的nums，所以这种
         * 做法是无效的，需要将nums所指向的数组修改才会真正意义上修改到nums数组。
         */
        // nums = ans;
    }

    public static void main(String[] args) {
        轮转数组 test = new 轮转数组();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        test.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
