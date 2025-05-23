package com.cy.class04;

/**
 * 测试连接：https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class Code04_ReverseNodesInKGroup {

    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        //第一组都没有凑齐都不用逆序了直接返回老head
        if (end == null) {
            return head;
        }

        //后面该怎么调整怎么调整，这个head就是要返回的，不要动它了。
        head = end;
        reverse(start, end);
        //lastEnd：上一组的结尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    /**
     * 给定链表的开始节点，数够k个，把数到的节点返回
     * 该组内元素不够k个，就返回null
     */
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }
}
