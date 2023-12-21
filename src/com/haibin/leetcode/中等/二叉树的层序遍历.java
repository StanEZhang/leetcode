package com.haibin.leetcode.中等;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @project: leetcode
 * @className: 二叉树的层序遍历
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-01
 */
public class 二叉树的层序遍历 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        // 使用队列实现层序遍历的顺序
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(list);
        }

        return ans;
    }
}
