package com.haibin.leetcode.简单;

/**
 * @program: leetcode 1
 * @ClassName 两数之和
 * @description:
 * @author: haibin
 * @create: 2022-12-11 19:35
 * @Version 1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 分析：
 *
 */
public class 两数之和 {
    /**
     * 暴力解法O(n^2)
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 哈希映射
     * 时间复杂度O(n),空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        /**
         遍历数组，把这些数一个一个拿出来，先拿出第一个A来问，
         target-A这个差在map里吗（O(1)复杂度）
         如果不在，把这个A连带着它的下标存到map,很显然第一个数肯定要存进去。
         轮到B的时候，map里放了A.
         轮到C的时候，map里放了A,B.
         轮到D的时候，map里放了A,B,C.
         按这个规律可以发现，不管map里放多少，我都只需要O(1)复杂度就能查出来有没有复合要求的数在里面。
         所以只需要遍历一次。
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
