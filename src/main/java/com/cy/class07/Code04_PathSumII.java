package com.cy.class07;

import java.util.ArrayList;
import java.util.List;

/**
 * 收集达标路径和
 */
public class Code04_PathSumII {

    // 测试链接：https://leetcode.com/problems/path-sum-ii
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayList<Integer> path = new ArrayList<>();
        process(root, path, 0, sum, ans);
        return ans;
    }

    /**
     * @param x
     * @param path   之前节点保留了哪些值，有一条路径
     * @param preSum 之前节点的和
     * @param sum    待匹配的求和值
     * @param ans    达标的路径集合
     */
    public static void process(TreeNode x, List<Integer> path, int preSum, int sum, List<List<Integer>> ans) {
        //叶子节点的情况
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                path.add(x.val);
                ans.add(copy(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        //非叶子节点的情况
        path.add(x.val);
        preSum += x.val;
        if (x.left != null) {
            process(x.left, path, preSum, sum, ans);
        }
        if (x.right != null) {
            process(x.right, path, preSum, sum, ans);
        }
        //节点往左、往右都遍历完了，即将返回到上级节点了，你是不是该把自己节点删掉呢？对吧
        path.remove(path.size() - 1);
    }

    /**
     * 非叶子节点的时候，遍历下级节点时，
     * 遍历左树，添加自身节点到path，遍历完后删除自身。
     * 遍历右树，添加自身节点到path，遍历完后删除自身。
     * 所以这样写也行：
     * 好理解一点吧。
     */
    public static void process2(TreeNode x, List<Integer> path, int preSum, int sum, List<List<Integer>> ans) {
        //叶子节点的情况
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                path.add(x.val);
                ans.add(copy(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        //非叶子节点的情况
        preSum += x.val;
        if (x.left != null) {
            path.add(x.val);
            process(x.left, path, preSum, sum, ans);
            path.remove(path.size() - 1);
        }
        if (x.right != null) {
            path.add(x.val);
            process(x.right, path, preSum, sum, ans);
            path.remove(path.size() - 1);
        }
    }

    public static List<Integer> copy(List<Integer> path) {
        List<Integer> ans = new ArrayList<>();
        for (Integer num : path) {
            ans.add(num);
        }
        return ans;
    }

}
