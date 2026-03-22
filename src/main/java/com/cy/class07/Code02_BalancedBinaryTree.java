package com.cy.class07;


public class Code02_BalancedBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 返回这棵树是否是平衡树
     */
    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    /**
     * 以某个节点为头的时候，返回两个信息：
     * 1.整棵树是否平衡
     * 2.整棵树的高度
     */
    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    /**
     * 以x为头的时候计算的结果，不是单一的是否平衡这一个信息，而是返回一个info，info里面放着两个信息
     * x对于子树节点，既要返回平不平，也要返回高度。
     * 但我们写的可是递归呀，递归对于所有节点是一视同仁的，如果你要再递归里完成对于x左树、和右树的要求，
     * 那么你也得做到在递归里返回同样多的信息，整个递归才能连起来。
     */
    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(true, 0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info(isBalanced, height);
    }
}
