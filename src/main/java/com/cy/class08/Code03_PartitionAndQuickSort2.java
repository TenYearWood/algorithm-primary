package com.cy.class08;

/**
 * 快速排序，递归方法实现
 */
public class Code03_PartitionAndQuickSort2 {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        // L < R
        int[] equalE = partition(arr, L, R);
        // equalE[0] 等于区域第一个数
        // equalE[1] 等于区域最后一个数
        process(arr, L, equalE[0] - 1);
        process(arr, equalE[1] + 1, R);
    }

    /*
    * 自己写的，不好，上面的代码写法：
    * 直接第一个就是边界条件：L >= R 就退出了。
    * 多往下执行了一步，但是好理解，大不了再调一次，只是边界不符合了，直接return。
    public static void process(int[] arr, int L, int R) {
        int[] part = partition(arr, L, R);
        if (part[0] == L || part[1] == R) {
            return;
        }

        process(arr, L, part[0] - 1);
        process(arr, part[1] + 1, R);
    }*/

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
