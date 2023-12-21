package com.haibin.leetcode.简单;

/**
 * @project: leetcode
 * @className: 找出字符串中第一个匹配项的下标
 * @description:
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串
 * 的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * @author: zhanghaibin
 * @create: 2023-09-01
 */
public class 找出字符串中第一个匹配项的下标 {
    public int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            String substring = haystack.substring(i, i + n);
            if (needle.equals(substring)) {
                return i;
            }
        }
        return -1;

    }
}
