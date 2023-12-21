package com.haibin.leetcode.简单;

/**
 * @project: leetcode
 * @className: 二叉树的最大深度
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-11
 */



public class 二叉树的最大深度 {
    static class TreeNode {
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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
