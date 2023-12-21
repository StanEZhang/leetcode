package com.haibin.leetcode.中等;

/**
 * @project: leetcode
 * @className: 盛水最多的容器
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-27
 */

/**
 * 自己做出来了哈哈哈哈！
 * 解析：
 * 首先力扣上上是写了这道题是用双指针解题的，所以提前如果知道双指针会比较容易
 * 双指针顾名思义就是2个指针，一般都是左右2个，向内收缩
 * 1. 双指针从两边向内移动
 *      发现：
 *      如果从长边向内收缩，长方形面积只会减少，永远不会增加（因为容器高度由短边决定，而宽度在减少）
 *      所以：
 *      要想求最大面积，必须从短边收缩
 * 2. 从短边收缩后，求出面积s2,与之前的s1比较，取更大值
 * 3. 停止条件： 下标重合
 * 4. 返回最大值
 *
 */
public class 盛水最多的容器 {
    public int maxArea(int[] height) {
        // 定义左右指针
        int left = 0;
        int right = height.length - 1;
        // 面积
        int area = 0;
        // 循环
        while (left < right) {
            // 定义长方形的长和宽，长方形的面积
            int length = right - left;
            int width = Math.min(height[left], height[right]);
            area = Math.max(area, length * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
