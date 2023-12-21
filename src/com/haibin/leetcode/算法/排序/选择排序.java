package com.haibin.leetcode.算法.排序;

/**
 * 从所有待选数字中选出最小的，记录下这个最小的数的下标，让它和最左边的数字交换位置
 * 循环
 */
public class 选择排序 {
    public static int[] choose(int[] arr) {

        // 从待选中选个最小的
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 循环完了放最左边
            swap(i,min,arr);
        }
        return arr;
    }
    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,6,4,1,9,88,67};
        int[] choose = choose(arr);
        for (int i = 0; i < choose.length; i++) {
            System.out.println(choose[i]);
        }
    }
}
