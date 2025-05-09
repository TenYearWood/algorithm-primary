package com.cy.class04;

/**
 * @description com.cy.class04
 * @author: chengyu
 * @date: 2025-05-02 15:24
 */
public class Code06_MergeTwoSortedLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    /**
     * head: 两个两笔头节点值的大小决定了谁是小头。更小的那个是小头。
     * cur1：小头的下一个是cur1。cur1别从头出发，从下一个开始出发
     * cur2: 大头的第一个是cur2
     */
    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val <= head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }
}
