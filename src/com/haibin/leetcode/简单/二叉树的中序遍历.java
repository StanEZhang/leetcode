package com.haibin.leetcode.简单;

import java.util.LinkedList;
import java.util.List;

/**
 * @project: leetcode
 * @className: 二叉树的中序遍历
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-18
 */
public class 二叉树的中序遍历 {

     public class TreeNode {
         int val;
        TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    LinkedList<Integer> list = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new LinkedList<>();
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
