package com.haibin.leetcode.中等;

import java.util.HashMap;

/**
 * @project: leetcode
 * @className: 和为K的子数组
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-06
 */
public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        // 前缀和
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // 前缀和
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
