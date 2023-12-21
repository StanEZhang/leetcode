package com.haibin.leetcode.简单;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @project: leetcode
 * @className: 多数元素
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-04
 */
public class 多数元素 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {

            if (map.containsKey(num)) {
                Integer count = map.get(num);
                count++;
                if (count > nums.length / 2) {
                    return num;
                }
                map.put(num, count);
            } else {
                map.put(num, 1);
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        多数元素 test = new 多数元素();
        int[] nums = {3, 3, 2};
        int i = test.majorityElement(nums);
        System.out.println(i);
    }
}
