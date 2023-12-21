package com.haibin.leetcode.简单;

import java.util.LinkedList;

/**
 * @project: leetcode
 * @className: 用队列实现栈
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-04
 */
public class 用队列实现栈 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        // 从队列的头部（front）移除并返回元素。poll=pollFirst
        list.poll();
        list.pollFirst();
        list.pollLast();
        // 查看队列头部（front）的元素但不移除它。peek=peekFirst
        Integer peek = list.peek();
        Integer integer = list.peekFirst();
        Integer integer1 = list.peekLast();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list);
    }
}
