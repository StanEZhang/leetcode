package com.haibin.leetcode.简单;

/**
 * @program: leetcode
 * @ClassName 最长公共前缀
 * @description:
 * @author: haibin
 * @create: 2022-12-20 15:04
 * @Version 1.0
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        // 公共前缀比所有字符串都短，随便选一个
        String prefix = strs[0];
        for (String str : strs) {
            while (!str.startsWith(prefix)) {
                if (prefix.length() == 0) return "";
                // 公共前缀不匹配就让它变短！
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;

    }

}
