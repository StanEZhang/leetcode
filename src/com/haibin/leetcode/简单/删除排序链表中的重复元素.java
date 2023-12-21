package com.haibin.leetcode.简单;

/**
 * @project: leetcode
 * @className: 删除排序链表中的重复元素
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-08
 */
public class 删除排序链表中的重复元素 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        /**
         * 为什么需要开一个cur来替代head，直接用head实现不了
         * 答：链表头要固定，cur一直在往后移动，不记住head找不到了
         */
        ListNode cur = head;
        while (cur.next != null) {

            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
