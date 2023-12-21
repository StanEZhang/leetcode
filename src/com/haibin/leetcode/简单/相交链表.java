package com.haibin.leetcode.简单;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @project: leetcode
 * @className: 相交链表
 * @description:
 * @author: zhanghaibin
 * @create: 2023-10-30
 */
public class 相交链表 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();

        // 遍历链表a,存到HashSet
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        System.out.println(set);
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;

    }
}
