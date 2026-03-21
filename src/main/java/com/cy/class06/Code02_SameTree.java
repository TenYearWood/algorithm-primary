package com.cy.class06;

/**
 * 测试链接：https://leetcode.com/problems/same-tree
 * 题目：
 * 给你两棵树，一颗树的节点叫P，一颗树的节点叫Q，这两颗树是独立的两棵树，
 * 如果P的所有结构 = Q的所有结构，叫两颗树相等。如果这两颗树有任何一点对不上，就不叫相等。
 * 请写一个方法判断P是否等于Q？
 */
public class Code02_SameTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    /**
     * ^ 用于布尔值时，是逻辑异或运算符
     * 当操作数是布尔类型时，^ 表示逻辑异或： 两个布尔值不同时返回 true，相同时返回 false
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //有一个为空，有一个不为空
        if (p == null ^ q == null) {
            return false;
        }

        //都为空
        if (p == null && q == null) {
            return true;
        }

        // 都不为空
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
