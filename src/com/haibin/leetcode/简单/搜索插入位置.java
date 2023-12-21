package com.haibin.leetcode.简单;

/**
 * @project: leetcode
 * @className: 搜索插入位置
 * @description:
 * @author: zhanghaibin
 * @create: 2023-10-07
 */
public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return left;

    }
}
