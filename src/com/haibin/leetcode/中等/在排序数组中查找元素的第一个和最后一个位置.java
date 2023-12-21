package com.haibin.leetcode.中等;

/**
 * @project: leetcode
 * @className: 在排序数组中查找元素的第一个和最后一个位置
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-11
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    // 大家不要太纠结，搞两次正常的二分查找就好了，不要想什么大于等于，什么大于，就是等于，就找等于的
    // 两次二分查找，分开查找第一个和最后一个
    // 时间复杂度 O(log n), 空间复杂度 O(1)
    // [1,2,3,3,3,3,4,5,9]
    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        int last = -1;
        // 找第一个等于target的位置
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                first = middle;
                right = middle - 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // 最后一个等于target的位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                last = middle;
                left = middle + 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return new int[]{first, last};
    }
    /**
     * 自己实现的笨方法
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};

        }
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans[0] = i;
                break;
            }
            ans[0] = -1;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                ans[1] = i;
                break;
            }
            ans[1] = -1;
        }
        return ans;
    }
}
