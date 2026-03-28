package com.cy.class07;

/**
 * 二叉树能否组成路径和
 */
public class Code03_PathSum {

    // 测试链接：https://leetcode.com/problems/path-sum
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSum = false;

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, sum);
        return isSum;
    }

    /**
     * @param x      头节点
     * @param preSum 之前从头节点一路累加下来的路径和
     * @param sum    待求的和
     */
    public static void process(TreeNode x, int preSum, int sum) {
        //x是叶子节点
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                isSum = true;
            }
            return;
        }
        //x是非叶子节点
        preSum += x.val;
        if (x.left != null) {
            process(x.left, preSum, sum);
        }
        if (x.right != null) {
            process(x.right, preSum, sum);
        }
    }
}
