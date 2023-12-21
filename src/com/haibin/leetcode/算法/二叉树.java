package com.haibin.leetcode.算法;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @project: leetcode
 * @className: 二叉树
 * @description:
 * @author: zhanghaibin
 * @create: 2023-09-04
 */
public class 二叉树 {
    /* 二叉树节点类 */
    static class TreeNode {
        int val;         // 节点值
        TreeNode left;   // 左子节点引用
        TreeNode right;  // 右子节点引用
        TreeNode(int x) { val = x; }
    }

    /** 层序遍历
     * offer 方法用于将指定的元素插入到队列中，如果这样做不会违反队列的容量限制。这个方法通常比 add 方法更可取，尤其是在使用有容量限制的队列时。
     * 两者之间的主要区别在于它们的行为方式：
     * add 方法：如果添加元素成功，它会返回 true。但是，如果队列已满，它会抛出一个 IllegalStateException 异常。
     * offer 方法：如果添加元素成功，它也会返回 true。但是，如果队列已满，它会返回 false，而不是抛出异常。
     * 因此，offer 方法提供了一种更为平和的方式来处理容量限制问题。如果队列已满，它不会导致程序崩溃，而是允许你采取其他措施。
     * 这就是为什么在使用有容量限制的队列时，offer 方法通常更为可取。它使你能更灵活地控制程序的流程，而不必担心异常处理。
     */
    List<Integer> levelOrder(TreeNode root) {
        // 初始化队列，加入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 初始化一个列表，用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // 队列出队
            list.add(node.val);           // 保存节点值
            if (node.left != null) {
                queue.offer(node.left);   // 左子节点入队
            }
            if (node.right != null) {
                queue.offer(node.right);  // 右子节点入队
            }
        }
        return list;
    }

    /**
     * 以下三种为深度优先搜索：https://www.hello-algo.com/chapter_tree/binary_tree_traversal/#722
     * 深度优先搜索通常基于递归实现
     */

    /** 前序遍历 ：常用于拷贝二叉树*/
    void preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return;
        }
        // 访问优先级：根节点 -> 左子树 -> 右子树
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /** 中序遍历 ：常用于将二叉搜索树转换为有序数组*/
    void inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return;
        }
        // 访问优先级：左子树 -> 根节点 -> 右子树
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /** 后序遍历 ：常用于计算二叉树的高度*/
    void postOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return;
        }
        // 访问优先级：左子树 -> 右子树 -> 根节点
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }


}
