package com.haibin.leetcode.算法.排序;

/**
 * @project: leetcode
 * @className: 插入排序
 * @description:
 * @author: zhanghaibin
 * @create: 2023-12-20
 */
public class 插入排序 {
    public static int[] insert(int[] arr) {

        int length = arr.length;
        // 1.从第二个人开始循环
        for (int i = 1; i < length; i++) {
            int temp = arr[i];
            for (int j = (i - 1); j >= 0; j--) {
                if (temp > arr[j]) {
                    arr[j + 1] = temp;
                    break;
                } else {
                    // 比小明高的往后退一格往后站！
                    arr[j + 1] = arr[j];
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 66, 99, 6, 4};
        int[] insert = insert(arr);
        for (int i = 0; i < insert.length; i++) {
            System.out.println(insert[i]);
        }
    }
}
