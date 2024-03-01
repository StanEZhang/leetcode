package com.haibin.leetcode.简单;

import java.util.Arrays;

/**
 * @project: leetcode
 * @className: 移动零
 * @description:
 * @author: zhanghaibin
 * @create: 2023-06-28
 */

/**
 * 这道题的话看长相有点像冒泡。
 * 你看这个思路就应该是什么呢？
 * 遍历这个数组，如果你是0的话，就跳过去。
 * 如果你不是0，就往上也就是往左冒泡。
 * 说冒泡是因为形象一些，实际上的话就是循环换位置。
 * 这里需要注意的问题就是：
 * 比方说你1冒泡到顶上了。
 * 那你第二个非零的数3往上冒泡就不能冒泡到最顶，就得在1下边。
 * 那怎么实现呢？
 * 比较简单，就是每次循环到非0的数就记一次。
 * 还是比较好理解。
 * 下面就写一下实现。
 * 实现过程中发现，冒泡的过程中不需要逐个交换位置，直接换一次就可以了。
 * 因为当前非0的数到上一个非0的数之间一定全是0.
 *
 * 按moveZeroes2提交有报错，原因是没有控制边界条件。
 * 第二次提交错误，原因是交换位置没有按正常程序走，想当然了。
 */

public class 移动零 {
    /**
     * @date: 2024/03/01
     输入: nums = [0,1,0,3,12]
     输出: [1,3,12,0,0]
     */
    /**
        冒泡过程
     0 1 0 3 12
     1 0 0 3 12
     1 3 0 0 12
     1 3 12 0 0

     */
    public int[] moveZeroes2(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        // 记录非0的数
        int n = 0;

        // 1,0,0,3
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                // 冒泡,交换位置
                int temp = nums[n];
                nums[n] = nums[i];
                nums[i] = temp;
                n++;
            }

        }
        return nums;

    }
    /**
     输入: nums = [0,1,0,3,12]
     输出: [1,3,12,0,0]
     */
    public int[] moveZeroes(int[] nums) {

        // 记录有几个非零
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[count] = nums[i];
                count++;
            }
        }

        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0};
        移动零 移动零 = new 移动零();
        int[] ints = 移动零.moveZeroes2(nums);
        System.out.println(Arrays.toString(ints));
    }
}
