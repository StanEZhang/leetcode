package com.haibin.leetcode.简单;

import java.util.HashSet;
import java.util.Set;

/**
 * @project: leetcode
 * @className: 数组中重复的数字
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-15
 */
public class 数组中重复的数字 {
    /**
     * 空间复杂度O(n)
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean flag = integers.add(nums[i]);
            if (!flag) {
                return nums[i];
            }
        }
        return -1;
    }
    /**
     * 空间复杂度O(1)
     *  原地交换
     */
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            // 如果对应不正确，则交换位置，让其对应正确
            // 交换位置之前要判断，当前值所对应的索引处，是否已经存在对应值，举个例子
            // eg. 当前值为3，索引为1，值3应该对应索引3，所以需要交换，但交换之前要判断3的位置是否有3，有则重复，return 3
            // 没有重复，则交换，i--退一格
            // 当前索引=i 值=nums[i]
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    // 交换
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                    i--;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 1, 2, 3, 3};
        数组中重复的数字 rep = new 数组中重复的数字();
        int repeatNumber2 = rep.findRepeatNumber2(ints);
        System.out.println(repeatNumber2);
    }
}
