package com.haibin.leetcode.简单;

/**
 * @program: leetcode
 * @ClassName 有效的括号
 * @description:
 * @author: haibin
 * @create: 2022-12-21 11:46
 * @Version 1.0
 */
public class 有效的括号 {
    public boolean isValid(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.length() == 0;
    }
}
