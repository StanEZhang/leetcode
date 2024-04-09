package com.haibin.leetcode.中等;

import sun.security.jca.GetInstance;

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

    /**
     * 解析：
     * 使用滑动窗口，要做的是保证窗口内一直没有重复元素，
     * 如何保证没有重复元素？用hashMap.
     * 如果出现了重复元素怎么办？
     * [0 1 2 3 4] 2 6 8 5
     * [0 1 2 3 4 2] 6 8 5
     * 0 1 2 [3 4 2] 6 8 5
     * 窗口left移动到重复元素下标+1的位置
     * 注意：left = Math.max(left,map.get(s.charAt(i)) + 1);
     * 为什么要取与原left相比的最大值？因为存在a b b a的情况
     * 因为map更新在下一步，没更新之前map里的a的下标依然是之前的，不取最大值就倒回去了，left又变成1了
     */

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
