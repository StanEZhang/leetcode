package com.haibin.leetcode.中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @project: leetcode
 * @className: 字母异位词分组
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-20
 */

/**
 * 思路：
 *  最主要的如何判断他们是异位词？？？？？？？？？？？
 *  把字符串变成字符数组
 *  对字符数组进行排序
 *  排完序在转回字符串，比较，一样就是异位词！！！
 *
 *  然后就是使用map来查找key,key一样的就是异位词，就把这个异位词添加进map对应的key的value
 *  这个value是个list
 *
 *  最后返回一个list,把map的values全放进去。
 *
 */


public class 字母异位词分组 {
    /**
     * 自己的复杂实现
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams01(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // str字符串排序
            char[] array = str.toCharArray();
            Arrays.sort(array);
            // 获取key aet
            String key = Arrays.toString(array);
            if (map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            List<String> values = map.get(key);
            values.add(str);
            map.put(key, values);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }


    /**
     * idea将上述代码简化
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams02(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // str字符串排序
            char[] array = str.toCharArray();
            Arrays.sort(array);
            // 获取key aet
            String key = Arrays.toString(array);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            List<String> values = map.get(key);
            values.add(str);
            map.put(key, values);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        字母异位词分组 test = new 字母异位词分组();
        String[] str = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> lists = test.groupAnagrams01(str);
        System.out.println(lists);
    }
}
