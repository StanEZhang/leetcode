package com.haibin.leetcode.简单;

/**
 * @project: leetcode
 * @className: 二叉树的直径
 * @description:
 * @author: zhanghaibin
 * @create: 2023-10-31
 */
public class 二叉树的直径 {

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

    int maxd = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        // 定义最大直径
        depth(root);
        return maxd;
    }

    private Integer depth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        maxd = Math.max(left + right, maxd);
        return Math.max(left, right) + 1;
    }
}
