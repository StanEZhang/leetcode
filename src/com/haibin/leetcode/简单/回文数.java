package com.haibin.leetcode.简单;

/**
 * @program: leetcode
 * @ClassName 回文数
 * @description:
 * @author: haibin
 * @create: 2022-12-20 09:17
 * @Version 1.0
 */
public class 回文数 {
    public boolean isPalindrome(int x) {

        String strX = String.valueOf(x);

        for (int i = 0; i <= strX.length() / 2 - 1; i++) {
            if (strX.charAt(i) != strX.charAt(strX.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
