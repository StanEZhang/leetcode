package com.haibin.leetcode.简单;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: leetcode
 * @className: 二叉树的前序遍历
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-09
 */
public class 二叉树的前序遍历 {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
}
