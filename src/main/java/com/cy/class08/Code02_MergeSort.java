package com.cy.class08;

/**
 * 归并排序
 */
public class Code02_MergeSort {

    //递归方法实现
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * arr[L...R]范围上，请让这个范围上的数，有序！
     * process(arr, L, mid)让左边部分有序。为什么能做到？
     * 你process不是号称一个范围上的数能让他变有序吗？左边部分怎么有序，递归。右边部分怎么有序？递归。
     * 左边部分变有序了 + 右边部分变有序了，往一起merge。你别管我怎么做到的，反正我就是能做到，这就是递归的黑盒。
     * 我把我base case: if (L == R) { 写好，以后每一步都按照递归来，就能做到。
     *
     * 就是这个递归这个事，你要是硬说，8个数画递归画死你，4个数少点画下就明白了。
     */
    public static void process(int[] arr, int L, int R) {
        //L=R表示数组只有一个数，已经有序了，不用排了。
        if (L == R) {
            return;
        }
        //int mid = (L + R ) / 2; mid也可以这么写
        int mid = L + ((R - L) >> 1);
        // 让左边部分有序
        process(arr, L, mid);
        // 让右边部分有序
        process(arr, mid + 1, R);
        // 如果左边部分变有序了 + 右边部分变有序了，则一起merge
        merge(arr, L, mid, R);
    }

    /**
     * merge方法有循环，但不是递归
     * L、M、R这三个参数就可以表示两段：左半部分、右半部分，隐含了两段：L ~ M，M + 1 ~ R，但你只用传三个参就够了。
     */
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        //当两半部分都没越界的时候
        while(p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //要么p1越界，要么p2越界，不可能出现共同越界
        while(p1 <= M) {
            help[i++] = arr[p1++];
        }
        while(p2 <= R) {
            help[i++] = arr[p2++];
        }
        //help数组生成好了，覆盖回去
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
