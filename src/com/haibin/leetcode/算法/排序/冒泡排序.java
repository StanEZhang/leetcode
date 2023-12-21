package com.haibin.leetcode.算法.排序;

import java.util.List;

/**
 * @project: leetcode
 * @className: 冒泡排序
 * @description:
 * @author: zhanghaibin
 * @create: 2023-12-20
 */
public class 冒泡排序 {

    public static int[] bubble(int[] arr) {
        int length = arr.length;
        while (length > 1) {
            for (int i = 0; i < length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(i,arr);
                }
            }
            length--;
        }
        return arr;
    }

    private static void swap(int i, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 66, 99, 6, 4};

        int[] bubble = bubble(arr);
        for (int i : bubble) {
            System.out.println(i);
        }
    }
}
