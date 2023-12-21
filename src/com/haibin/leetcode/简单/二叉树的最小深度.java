package com.haibin.leetcode.简单;

/**
 * @project: leetcode
 * @className: 二叉树的最小深度
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-18
 */

/**
 * 力扣网友总结递归技巧
 * ---写出结束条件
 * ---不要把树复杂化，就当做树是三个节点，根节点，左子节点，右子节点
 * ---只考虑当前做什么，不用考虑下次应该做什么
 * ---每次调用应该返回什么
 */
public class 二叉树的最小深度 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int minDepth(TreeNode root) {
        /**
         * 这里的写法可以参考 对称二叉树
         */
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        if (root.left != null) {
            return minDepth(root.left) + 1;
        }
        return minDepth(root.right) + 1;
    }
}

