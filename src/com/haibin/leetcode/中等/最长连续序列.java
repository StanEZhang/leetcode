package com.haibin.leetcode.中等;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @project: leetcode
 * @className: 最长连续序列
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-22
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 数组转换成哈希set
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 定义最长长度
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            int cur = nums[i];  // 注意这里
            int curMax = 1;
            while (set.contains(cur + 1)) {
                cur = cur + 1;  // 注意这里
                curMax++;
            }
            max = Math.max(max, curMax);
        }

        return max;
    }
}
