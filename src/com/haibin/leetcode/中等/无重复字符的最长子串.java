package com.haibin.leetcode.中等;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @project: leetcode
 * @className: 无重复字符的最长子串
 * @description:
 * @author: zhanghaibin
 * @create: 2023-06-05
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        String s = "qrsvbspk";
        无重复字符的最长子串 无重复字符的最长子串 = new 无重复字符的最长子串();

        int i = 无重复字符的最长子串.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    public int lengthOfLongestSubstring(String s) {

        if (s.length()==0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;//最长子串长度
        int left = 0;//滑动窗口左下标，i相当于滑动窗口右下标
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){//charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
                left = Math.max(left,map.get(s.charAt(i)) + 1);       //map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
            }        //map.get('a')=0,因为map中只有第一个a的下标，然后更新left指针到原来left的的下一位
            map.put(s.charAt(i),i);      //再更新map中a映射的下标
            max = Math.max(max,i-left+1);     //比较两个参数的大小
        }
        return max;
    }

}
