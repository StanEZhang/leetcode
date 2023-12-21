package com.haibin.leetcode.中等;

/**
 * @project: leetcode
 * @className: 缺失的第一个正数
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-07
 */
public class 缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        /**
         * 如果数组长度为5，数组为1,2,3,4,5也就是全齐了，那么输出结果就是6，也就是n+1
         * 如果数组是1,2，4,5,6或者1,2,3,4,6也就是1-n填不满，那么输出结果一定是1-n中的某个整数
         * 核心思路：把数组当成哈希表用
         * 怎么个用法呢？
         * 就是给数组中的数字打标记（充分利用数组下标），遍历一遍，如果nums[i]属于1-n,那么就打标记
         * 比如，如果nums[i]是2，也就是第二个数，数组第二个数下标是1，那么就把nums[nums[i]-1]打上负号
         * 但是数组原来就有负号啊？简单，遍历一遍去掉负号
         * 最后再遍历，找出不带符号的第一个数，如果没有，返回n+1
         *
         */
        int n = nums.length;
        // 遍历第一遍去掉0和负号
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // 遍历第二遍，打标记
        // 这里要注意，如果不使用绝对值方法，容易产生nums[-5]这种数组越界
        // 其实本质上就是，我们这次遍历需要的是删去负号以外的那个正数，因为这里的负数对计算机来说是有意义的
        // 而对于开发者对我们来说，这个负号只作为一个标记，所以需要去掉他，通过绝对值方法
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 遍历第三遍，找出不为负数，返回，如果都为负数返回n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        缺失的第一个正数 test = new 缺失的第一个正数();
        int[] arr = {3, 4, -1, 1};
        System.out.println(test.firstMissingPositive(arr));
    }
}
