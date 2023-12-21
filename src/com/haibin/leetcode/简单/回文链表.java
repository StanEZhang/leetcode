package com.haibin.leetcode.简单;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @project: leetcode
 * @className: 回文链表
 * @description:
 * @author: zhanghaibin
 * @create: 2023-10-30
 */
public class 回文链表 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public boolean isPalindrome(ListNode head) {
        // 遍历链表
        // 将value分别存入LinkedList，一个add,一个push
        LinkedList<Integer> addList = new LinkedList<>();
        LinkedList<Integer> pushList = new LinkedList<>();

        while (head != null) {
            addList.add(head.val);
            pushList.push(head.val);
            head = head.next;
        }

        if (addList.equals(pushList)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        System.out.println(list);
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list);
        System.out.println("========");
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        System.out.println(list2);
        System.out.println(list2.pop());
        System.out.println(list2.pop());
        System.out.println(list2.pop());
        System.out.println(list2.pop());
        System.out.println(list2.pop());
        System.out.println(list2);
    }
}
