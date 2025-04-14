package com.cy.class04;

/**
 *
 */
public class Code01_ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    /**
     * 单链表的逆序
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 双链表的逆序
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);

        n1 = reverseLinkedList(n1);


//        while(n1 != null) {
//            System.out.print(n1.value + " ");
//            n1 = n1.next;
//        }
//        System.out.println();
    }
}
