package com.haibin.leetcode.简单;

/**
 * @project: leetcode
 * @className: 合并两个有序数组88
 * @description:
 * @author: zhanghaibin
 * @create: 2023-07-10
 */
public class 合并两个有序数组88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = m + n - 1;
        for (int i = count; i >= 0; i--) {
            if (m - 1 == -1) {
                nums1[i] = nums2[n - 1];
                n--;
                continue;

            }
            if (n - 1 == -1) {
                nums1[i] = nums1[m - 1];
                m--;
                continue;

            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

    public static void main(String[] args) {
        合并两个有序数组88 合并两个有序数组88 = new 合并两个有序数组88();
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0;
        int n = 1;
        合并两个有序数组88.merge(nums1, m, nums2, n);
    }
}
