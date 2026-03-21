package com.cy.class06;

/**
 * 二叉树结构
 */
public class TraversalBinaryTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    /**
     * 递归序
     * 如果把打印行为放在1的位置，先序遍历。放在2的位置，中序遍历。放在3的位置，后序遍历。
     * f是一个递归过程
     */
    public static void f(Node head) {
        if (head == null) {
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }

    /**
     * 三种顺序的打印方法如下，发现一个好玩的事情：
     * 如果把打印的一行代码System.out.println(head.value)去掉，发现先序、中序、后序的三个打印实现代码完全一样的。
     * 为什么打印加的不同会导致三种序呢？背后一定有更实质的东西。就是递归序。
     */

    // 先序打印所有节点
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    // 中序打印所有节点
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    //后续打印所有节点
    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos(head);
        System.out.println("========");
    }
}
