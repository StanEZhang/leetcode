package com.haibin.leetcode.简单;

import java.util.LinkedList;

/**
 * @project: leetcode
 * @className: 图书整理
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-15
 */
public class 图书整理 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] reverseBookList(ListNode head) {

        LinkedList<Integer> list = new LinkedList<>();
        while (head!= null) {
            // 等价于addFirst()
            list.push(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            // 等价于removeFirst
            ans[i] = list.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        图书整理 test = new 图书整理();
        ListNode head = new ListNode(3);
        ListNode b =new ListNode(6);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(1);
        head.next = b;
        b.next = c;
        c.next = d;
        System.out.println(test.reverseBookList(head));
    }
}
