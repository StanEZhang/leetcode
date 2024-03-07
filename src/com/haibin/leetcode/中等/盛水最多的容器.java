package com.haibin.leetcode.中等;

/**
 * @project: leetcode
 * @className: 盛水最多的容器
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-27
 */

/**
 * @create: 2023-09-27
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

/**
 * @Date:2024-03-04
 * 解析：
 * 第一，这道题首先要知道是双指针。
 * 第二，面积=底边×高
 * 指针移动的过程当中必须找到确定性。
 * 在这里确定性是什么？
 * =移动长边面积永远是减少的=
 * =只有移动短边才可能获取更大面积=
 *
 * 分析为什么：
 * 1. 向内移动长边的时候，只有两种情况
 *    -如果下一条变长，那么高不变，底边变短，则面积减少
 *    -如果下一条变短，那么高减小，底边变短，则面积减小
 * 2. 向内移动短边的时候也是这两种情况
 *    -如果下一条变长，那么高增加，地板变短，面积不一定如何变化
 *    -如果下一条变短，那么高较小，底边变短，面积减小
 * 所以只能向内移动短边才有机会获得更大面积，才能“遍历”到所有可能是最大面积的情况。
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
    public int maxArea2(int[] height) {
        // 定义左右指针
        int left = 0;
        int right = height.length - 1;
        // 定义最大面积
        int maxArea = 0;

        // 遍历
        while (left <= right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left
            ));

            // 左侧高度 height[left],右侧高度 height[right]
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
