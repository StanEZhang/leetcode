package com.haibin.leetcode.简单;

/**
 * @project: leetcode
 * @className: 对称二叉树
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-15
 */
public class 对称二叉树 {
    /**
     * Definition for a binary tree node.
     */
     public class TreeNode {
         int val;
         TreeNode right;
         TreeNode() {}
         TreeNode left;
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    public boolean isSymmetric(TreeNode root) {
        /**
         * 补充德摩根定律：
         * 德摩根定律是布尔代数中的一个基本定律，它描述了逻辑运算中的“与”和“或”运算的关系。德摩根定律有两个部分，分别是：
         * 非 (A 与 B) 等于 (非 A 或 非 B)
         * 用符号表示为：¬(A ∧ B) = (¬A ∨ ¬B)
         *
         * 非 (A 或 B) 等于 (非 A 与 非 B)
         * 用符号表示为：¬(A ∨ B) = (¬A ∧ ¬B)
         */
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return check(left, right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        /**
         这里有且只有4种情况如下：
         左null, 右null
         左非null, 右非null
         左null, 右非null
         左非null, 右null
         */

        // 这里通过return排除一种情况，剩余情况如下
        // 左null, 右null       ×
        // 左非null, 右非null
        // 左null, 右非null
        // 左非null, 右null
        if (left == null && right == null) {
            return true;
        }

        // 这里排除2种情况，分别是左null，和右null，因为上面排除了左右同时为null的情况
        // 所以如果左null则右一定非null,如果右null则左一定非null
        // 所以再排除2种，剩余如下
        // 左null, 右null       ×
        // 左非null, 右非null
        // 左null, 右非null     ×
        // 左非null, 右null     ×
        if (left == null || right == null) {
            return false;
        }

        // 现在只剩一种情况，左右都非null,这种情况下，值不相等就不对称
        if (left.val != right.val) {
            return false;
        }

        // 最后剩下的就是左右非null,且值相等，可以递归，因为左右都有各自的子树，对称的条件为：
        // left.left = right.right 且 left.right = right.left
        // 所以递归如下

        return check(left.left,right.right) && check(left.right, right.left);
    }
}
