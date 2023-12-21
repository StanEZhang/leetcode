package com.haibin.leetcode.简单;


/**
 * @project: leetcode
 * @className: 翻转二叉树
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-18
 */
public class 翻转二叉树 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        翻转二叉树.TreeNode right;
        TreeNode() {}
        翻转二叉树.TreeNode left;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, 翻转二叉树.TreeNode left, 翻转二叉树.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        翻转二叉树.TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        if (root.left != null) {
            invert(root.left);
        }
        if (root.right != null) {
            invert(root.right);

        }
    }
}
