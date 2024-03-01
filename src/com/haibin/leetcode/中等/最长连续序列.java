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

/**
 * 第一步：
 * 把这个数组元素全部扔进HashSet去重，去重是一个目的。
 * 还有一个目的是为了查找元素复杂度O(1)
 *
 * 我们题目要找最长连续数列的长度。
 * 问题就转化为我们要找到最长连续数列。
 * 问题就转化为我们要找到这个序列的头儿。
 * 只要找到头儿，头一直+1+1，挨个找就能找到尾巴。
 * 那头儿的标志是什么？
 *
 * 如果这个X,在HashSet里找不到X-1,也就是没有比它更小的了。
 * 意味着X要么是孤儿，要么他就是序列的头儿。
 * 然后我们再while循环找X+1,一直到找不到为止，找到序列的尾巴。
 * 过程中计数，算出序列长度。
 * 然后之前我们必须记录一个最大长度。
 * 然后这两个长度比较的最大值才是最终的最大长度。
 *
 * 回到上一段分析的开头，那这个X要是在HashSet里找到了X-1说明什么？
 * 说明它不是这个序列头啊。
 * 直接跳过就行了
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 数组转换成哈希set，去重
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
