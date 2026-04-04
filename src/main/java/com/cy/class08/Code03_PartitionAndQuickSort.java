package com.cy.class08;

import java.util.Arrays;

public class Code03_PartitionAndQuickSort {

    /**
     * 将一个数组以最右侧值划分，将<=mostR值的数放左区，将>mostR值的放右区
     * <p>
     * lessEqualR: <=区位置的右边界
     * index: 当前数下标
     * mostR: 最右侧的数，每次用来比较的那个数，下标
     */
    public static void splitNum1(int[] arr) {
        int lessEqualR = -1;
        int index = 0;
        int mostR = arr.length - 1;
        while (index < arr.length) {
            if (arr[index] <= arr[mostR]) {
                /**
                 * 等同于下面的一句代码：
                 * swap(arr, lessEqualR + 1, index);
                 * lessEqualR++;
                 * index++;
                 */
                swap(arr, ++lessEqualR, index++);
            } else {
                index++;
            }
        }
    }

    /**
     * 将数组划分成<区，=区，>区
     */
    public static void splitNum2(int[] arr) {
        int N = arr.length;
        int lessR = -1;
        int index = 0;
        int moreL = arr.length - 1;
        while (index < moreL) {
            if (arr[index] < arr[N - 1]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[N - 1]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, N - 1);
    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 5, 4, 5, 1, 4, 2, 4, 2, 3};
        splitNum2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
