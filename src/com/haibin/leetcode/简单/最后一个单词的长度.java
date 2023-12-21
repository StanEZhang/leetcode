package com.haibin.leetcode.简单;

/**
 * @project: leetcode
 * @className: 最后一个单词的长度
 * @description:
 * @author: zhanghaibin
 * @create: 2023-06-27
 */
public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if(end < 0) {
            return 0;
        }
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;

    }
}
