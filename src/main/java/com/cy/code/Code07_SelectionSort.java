package com.cy.code;

import java.util.Arrays;

/**
 * 选择排序、冒泡排序、插入排序
 */
public class Code07_SelectionSort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        // 0 ~ n-1
        // 1 ~ n-1
        // 2 ~ n-1
        // i ~ n-1
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    /**
     * 冒泡排序
     * 就是先想一个小例子，然后把小例子进行抽象化
     * 每一次交换都是相邻的
     */
    public static void bubbleSort(int[] arr) {
        // 0 ~ n-1
        // 0 ~ n-2
        // 0 ~ n-3
        // 0 ~ end
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            // 0 ~ end 干一些事情
            // 0 1  1 2  2 3   3 4   ..   end-1 end 要不要换
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    /**
     * 插入排序
     * 手里的牌已经整理好了是有序的，新抓一张牌，从右往左滑，到一个合适顺序的位置插入。
     * <p>
     * newNumIndex - 1 >= 0  代表我的左边有数
     * 什么时候跳出循环？
     * 1.newNumIndex - 1 < 0 我的左边不再有数了，我最小且已经跑到了第一个位置，不能再往前了。
     * 2.我左边的数已经比我小了。我不需要再往前了。前面已经排好了序，我来到这个位置也排好了序。
     */
    public static void insertSort1(int[] arr) {
        // 0 ~ 0 完成
        // 0 ~ 1
        // 0 ~ 2
        // 0 ~ 3
        // 0 ~ n-1
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
    }

    /**
     * 插入排序简洁写法
     * pre >= 0 && arr[pre] > arr[pre + 1]：
     * 我不再有前一个位置了，或者我前一个位置不再比我大了。就终止for循环。跟insertSort1中的判断完全等效，只是代码更短了。
     */
    public static void insertSort2(int[] arr) {
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            // pre 新数的前一个位置  end - 1   end
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 5, 1, 6, 8, 1, 3, 5, 7, 5, 6};
        //selectSort(arr);
        //bubbleSort(arr);
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
