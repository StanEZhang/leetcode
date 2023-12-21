package com.haibin.leetcode.简单;

/**
 * @program: leetcode
 * @ClassName 二分查找
 * @description:
 * @author: haibin
 * @create: 2022-12-05 21:48
 * @Version 1.0
 */
public class 二分查找 {
    /** 二分查找仅适用于【有序】【数组】。
     * 《口诀》
     * 二分左右中间找
     * 一下找到运气好
     * 万一左右一直跳
     * 别忘加一减一奥
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }



}
