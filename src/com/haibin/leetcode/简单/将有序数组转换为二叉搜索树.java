package com.haibin.leetcode.简单;

/**
 * @project: leetcode
 * @className: 将有序数组转换为二叉搜索树
 * @description:
 * @author: zhanghaibin
 * @create: 2023-11-02
 */
public class 将有序数组转换为二叉搜索树 {

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
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = new TreeNode();
        if (nums.length == 0) {
            return null;
        }



        return null;
    }

}
