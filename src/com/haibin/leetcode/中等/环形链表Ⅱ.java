package com.haibin.leetcode.中等;

import com.haibin.leetcode.简单.环形链表;

import java.util.HashSet;

/**
 * @project: leetcode
 * @className: 环形链表Ⅱ
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-01
 */
public class 环形链表Ⅱ {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        // 思路 每个节点的地址不同
        HashSet<Integer> set = new HashSet<>();

        while (head != null) {
            if (!set.add(head.hashCode())) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
