package com.haibin.leetcode.简单;

import java.util.HashSet;

/**
 * @project: leetcode
 * @className: Test
 * @description:
 * @author: zhanghaibin
 * @create: 2023-04-25
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());
        HashSet<Object> objects = new HashSet<>();
        objects.add("重地");
        objects.add("通话");
        System.out.println(objects);
    }
}
