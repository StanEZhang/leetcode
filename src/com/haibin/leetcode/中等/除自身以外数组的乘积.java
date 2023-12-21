package com.haibin.leetcode.中等;

/**
 * @project: leetcode
 * @className: 除自身以外数组的乘积
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-07
 */
public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] L = new int[n];
        int[] R = new int[n];
        int[] ans = new int[n];

        // 第一次遍历初始化L数组计算前缀积
        L[0] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        // 第二次遍历初始化R数组计算后缀积
        R[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }
}
