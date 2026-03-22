package com.cy.class07;

import java.util.LinkedList;
import java.util.Stack;

public class StackTest {

    /**
     * Stack用作栈，但性能不是最快的，平时使用没问题
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        /**
         * linkedList来替代栈的功能
         * 加的时候从尾巴加addLast，弹的时候也从尾巴弹pollLast
         */
        LinkedList<Integer> s = new LinkedList<>();
        s.addLast(1);
        s.addLast(2);
        s.addLast(3);
        while(!s.isEmpty()) {
            System.out.println(s.pollLast());
        }

        /**
         * 如果你明确的知道栈的空间不大于某个数组，比如100，拿数组替代栈是最快的
         * 说的这些技巧啊，一般用在笔试的时候，要性能跑分，这里数组替代栈，最快！
         */
        int[] sta = new int[100];
        int index = 0;
        //加元素
        sta[index++] = 1;
        sta[index++] = 2;
        sta[index++] = 3;
        //弹出
        System.out.println(sta[--index]);
        System.out.println(sta[--index]);
        System.out.println(sta[--index]);
    }
}
