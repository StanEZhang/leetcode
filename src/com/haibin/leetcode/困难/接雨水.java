package com.haibin.leetcode.困难;


/**
 * @project: leetcode
 * @className: 接雨水
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-28
 */

public class 接雨水 {

    /**
     * 思路一：按列求
     * 1. 遍历数组，拿到当前列值m
     * 2.m左侧最高度为l, m右侧最高度为r
     * 3.找出l、r中的最小值，因为最小值决定了蓄水
     * 4.这个最小值分为三种情况，比m大，比m小，等于m
     * 5.只有当这个最小值比m大时，当前列才会存水，存水量为二者的差值
     * 6.遍历差值求和得到最终的存水量
     * 时间复杂度O(n2),空间复杂度O1
     */
    public int trap(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划
     * 上述解法存在一个问题是：需要在每次遍历中都要计算一次左右侧最大高度，导致复杂度上升
     * 那么我们的问题就是要解决:
     * 如何通过另一种更加简单高效的方式来计算出每次循环时左右两侧的最大高度，基本逻辑是不变的
     * 那么基本就是用空间换时间的方式
     * 我们额外构造两个数组，进行单独遍历。
     * 我们以maxLeft[]数组为例.
     * 那么maxLeft[i]的含义为：第i列左侧最大高度。
     * 下面的问题是：如何计算maxLeft[i]
     * 类似于迭代，maxLeft[i] = 第i列左侧（也就是i-1）列高度  和  maxLeft[i-1]  中的最大值。
     * 那通过2次循环计算出当前列左侧最大高度和右侧最大高度
     * 就可以按照暴力解法的思路完成该题。
     */

    public int trap2(int[] height) {
        int sum = 0;

        // 2个数组
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        // 计算每列左侧最大高度
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        // 计算每列右侧最大高度
        for (int i = height.length - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        // 遍历
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;

    }
}
