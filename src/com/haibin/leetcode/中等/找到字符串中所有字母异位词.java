package com.haibin.leetcode.中等;

import java.util.*;

/**
 * @project: leetcode
 * @className: 找到字符串中所有字母异位词
 * @description:
 * @author: zhanghaibin
 * @create: 2023-10-30
 */
public class 找到字符串中所有字母异位词  {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        Arrays.sort(pChars);

        for (int i = 0; i < sChars.length - pChars.length + 1; i++) {
            char[] sCharsTemp = new char[pChars.length];
            for (int j = 0; j < pChars.length; j++) {
                sCharsTemp[j] = sChars[j + i];
            }
            Arrays.sort(sCharsTemp);
            if (Arrays.equals(pChars, sCharsTemp)) {
                ans.add(i);
            }
        }

        return ans;
    }

    /**
     * 滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        int sLen=s.length();
        int pLen=p.length();
        List<Integer> ans = new ArrayList<Integer>();


        if(sLen<pLen){
            return ans;
        }
        //建立两个数组存放字符串中字母出现的词频，并以此作为标准比较
        int [] scount=new int[26];
        int [] pcount=new int[26];

        //当滑动窗口的首位在s[0]处时 （相当于放置滑动窗口进入数组）
        for(int i=0;i<pLen;i++){
            ++scount[s.charAt(i)-'a']; //记录s中前pLen个字母的词频
            ++pcount[p.charAt(i)-'a']; //记录要寻找的字符串中每个字母的词频(只用进行一次来确定)
        }

        //判断放置处是否有异位词(在放置时只需判断一次)
        if(Arrays.equals(scount,pcount)){
            ans.add(0);
        }

        //开始让窗口进行滑动
        for(int i=0;i<sLen-pLen;i++){ //i是滑动前的首位
            --scount[s.charAt(i) -'a'];       //将滑动前首位的词频删去
            ++scount[s.charAt(i+pLen) -'a'];  //增加滑动后最后一位的词频（以此达到滑动的效果）

            //判断滑动后处，是否有异位词
            if(Arrays.equals(scount,pcount)){
                ans.add(i+1);
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        找到字符串中所有字母异位词 test = new 找到字符串中所有字母异位词();
        String s = "ababababab";
        String p = "aab";
        System.out.println(test.findAnagrams2(s, p));
        System.out.println('z'-'a');
    }
}
