package com.haibin.leetcode.中等;

/**
 * @project: leetcode
 * @className: 和为k的子串
 * @description:
 * @author: zhanghaibin
 * @create: 2023-10-30
 */


/**
 * 要看懂这道题的解析需要先理解 =前缀和= 这个概念
 * 前缀和：
 前缀和是一个在数组、列表或序列上常见的概念，它可以用来优化多个查询操作，以便快速求出数组或列表中某个范围内的元素之和。
 假设你有一个数组 arr，其前缀和数组 preSum 会是这样一个新数组，其中 preSum[i] 存储的是 arr[0] + arr[1] + ... + arr[i]。
 使用前缀和数组后，如果你想知道原数组中从索引 i 到 j 的元素之和，
 你可以通过 preSum[j] - preSum[i-1]（当 i > 0）或直接 preSum[j]（当 i = 0）来获得。
 */

/**
 * 枚举法
 */
public class 和为k的子串 {
    public int subarraySum(int[] nums, int k) {

        return 0;
    }
}
