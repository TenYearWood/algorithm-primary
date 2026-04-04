package com.cy.class08;

import java.util.Stack;

/**
 * 快速排序，非递归方法实现
 */
public class Code03_PartitionAndQuickSort3 {

    /**
     * 一个L..R就是一个任务，把做任务这件事放在栈里面。
     * 如果栈不为空，说明任务没做完，继续做
     * partition方法可能会分裂出两个子任务，
     */
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length - 1));
        while (!stack.isEmpty()) {
            Job cur = stack.pop();
            int[] equals = partition(arr, cur.L, cur.R);
            if (equals[0] > cur.L) {   //有 < 区域，才有子任务
                stack.push(new Job(cur.L, equals[0] - 1));
            }
            if (equals[1] < cur.R) {   //有 > 区域，才有子任务
                stack.push(new Job(equals[0] + 1, cur.R));
            }
        }
    }

    public static class Job {
        public int L;
        public int R;

        public Job(int L, int R) {
            this.L = L;
            this.R = R;
        }
    }

    /**
     * 前面splitNum是在一个数组做划分，现在partition方法要在一个范围上做划分。
     * arr[L...R]范围上，拿arr[R]做划分值
     */
    public static int[] partition(int[] arr, int L, int R) {
        int lessR = L - 1;
        int index = L;
        int moreL = R;
        while (index < moreL) {
            if (arr[index] < arr[R]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, R);
        return new int[]{lessR + 1, moreL};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
