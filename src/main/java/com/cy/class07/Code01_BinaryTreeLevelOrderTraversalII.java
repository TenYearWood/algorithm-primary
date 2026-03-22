package com.cy.class07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 * 二叉树按层遍历并收集节点
 */
public class Code01_BinaryTreeLevelOrderTraversalII {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        List<List<Integer>> lists = levelOrderBottom(node);
        System.out.println(lists);
    }

    /**
     * 二叉树按层遍历并收集节点
     * 很多结构都可以做Queue，Queue是一个接口，LinkedList只是Queue的一种。可以用LinkedList来做这个队列
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curAns.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            ans.add(0, curAns);
        }
        return ans;
    }
}
