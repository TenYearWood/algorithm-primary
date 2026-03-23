package com.cy.class07;

/**
 * 判断是否是搜索二叉树
 */
public class Code05_IsBinarySearchTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean is, int ma, int mi) {
            isBST = is;
            max = ma;
            min = mi;
        }
    }

    /**
     * 判断是否搜索二叉树
     */
    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }

    /**
     * 如果x为null的时候，不能返回new Info(true,0,0)，因为x是单节点-5，那么得到左树0比它大，这会导致单节点-5不是搜索二叉树了。
     */
//    public static Info process(TreeNode x) {
//        if (x == null) {
//            return null;
//        }
//
//        Info leftInfo = process(x.left);
//        Info rightInfo = process(x.right);
//
//        int max = x.val;
//        int min = x.val;
//        if (leftInfo != null) {
//            max = Math.max(leftInfo.max, max);
//            max = Math.min(leftInfo.max, max);
//        }
//        if (rightInfo != null) {
//            max = Math.max(rightInfo.max, max);
//            max = Math.min(rightInfo.max, max);
//        }
//
//        boolean isBST = true;
//        if (leftInfo != null && !leftInfo.isBST) {
//            isBST = false;
//        }
//        if (rightInfo != null && !rightInfo.isBST) {
//            isBST = false;
//        }
//
//        //left Max < x      right min > x
//        boolean leftMaxLessX = leftInfo == null ? true : leftInfo.max < x.val;
//        boolean rightMinMoreX = rightInfo == null ? true : rightInfo.min > x.val;
//        if (!leftMaxLessX || !rightMinMoreX) {
//            isBST = false;
//        }
//
//        return new Info(isBST, max, min);
//    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.val;
        int min = x.val;
        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }
        boolean isBST = false;
        boolean leftIsBst = leftInfo == null ? true : leftInfo.isBST;
        boolean rightIsBst = rightInfo == null ? true : rightInfo.isBST;
        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
        if (leftIsBst && rightIsBst && leftMaxLessX && rightMinMoreX) {
            isBST = true;
        }
        return new Info(isBST, max, min);
    }
}
