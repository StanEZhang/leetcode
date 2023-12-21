package com.haibin.leetcode.困难;

/**
 * @project: leetcode
 * @className: x的平方根
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-07
 */
public class x的平方根 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if ((long)mid * mid > x) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }
}
