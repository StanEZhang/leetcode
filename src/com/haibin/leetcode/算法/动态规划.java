package com.haibin.leetcode.算法;

/**
 * @project: leetcode
 * @className: 动态规划
 * @description:
 * @author: zhanghaibin
 * @create: 2023-10-31
 */
public class 动态规划 {


    /**
     * 爬楼梯问题：暴力搜索
     */
    // 搜索方法
     int dfs(int i){
        if (i == 1 || i == 2) {
            return i;
        }
        int count = dfs(i - 1) + dfs(i - 2);
        return count;
    }
    // 爬楼梯：搜索
     int climbStairsDFS(int n){
        return dfs(n);
    }


    /**
     * 用记忆表优化搜索
     *
     * @param args
     */
    // 初始化一个数组
    private int[] mem;

    public 动态规划(int n) {
        this.mem = new int[n + 1];
    }

    int dfs2(int n) {
        if (mem[n] > 0) {
            return mem[n];
        }
        if (n == 1 || n == 2) {
            return n;
        }
        mem[n] = dfs2(n - 1) + dfs2(n - 2);
        return mem[n];
    }

    int climbStairsDFS2(int n) {
        return dfs2(n);
    }


    public static void main(String[] args) {
        // 20可以，200超时，20000栈溢出
        动态规划 test = new 动态规划(40);
        System.out.println(test.climbStairsDFS2(40));
    }
}
