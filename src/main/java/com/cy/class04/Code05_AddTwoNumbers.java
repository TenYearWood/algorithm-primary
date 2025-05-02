package com.cy.class04;

/**
 * 两个链表相加
 */
public class Code05_AddTwoNumbers {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int value) {
            this.val = value;
        }
    }

    /**
     * 变量last的作用：
     * 第三阶段curl和curs都走到最后了，如果还有进位信息，要产生一个进位1
     * 但之前的节点在哪呢？因为要将之前的节点的next指向新创建的1.
     * 之前的节点已经找不到了，因为curl和curs都走到null了，谁的next指针去指向这个新节点1呢？
     * 最后一个不是null的节点去指向这个1
     * 这就是last的作用。
     *
     * last一直跟踪curl，就为了最后挂节点1的时候，知道挂在哪。
     */
    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);

        /**
         * l: 较长链表的头
         * s: 较短链表的头
         */
        ListNode l = len1 >= len2 ? head1 : head2;
        ListNode s = l == head1 ? head2 : head1;
        ListNode curL = l;
        ListNode curS = s;
        ListNode last = curL;
        int carry = 0;
        int curNum = 0;

        //第一阶段
        while (curS != null) {
            curNum = curL.val + curS.val + carry;
            curL.val = curNum % 10;
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }

        //第二阶段
        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = curNum % 10;
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }

        //第三阶段
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return l;
    }

    /**
     * 求链表长度
     */
    public static int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
