package com.haibin.leetcode.简单;

import java.util.HashSet;

/**
 * @project: leetcode
 * @className: 环形链表
 * @description:
 * @author: zhanghaibin
 * @create: 2023-10-30
 */
public class 环形链表 {

    class ListNode {
        int val;
        ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }


    public boolean hasCycle(ListNode head) {



        // 思路 每个节点的地址不同
        HashSet<Integer> set = new HashSet<>();

        while (head != null) {
            if (!set.add(head.hashCode())) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
