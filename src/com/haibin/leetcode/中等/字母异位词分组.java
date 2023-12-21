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
public class 字母异位词分组 {
    /**
     * 自己的复杂实现
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams01(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
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
        List<List<String>> result = new ArrayList<List<String>>();
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
