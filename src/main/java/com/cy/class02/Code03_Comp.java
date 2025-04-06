package com.cy.class02;

import java.util.Arrays;

/**
 * 对数器的使用
 */
public class Code03_Comp {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    /**
     * 返回一个数组arr，arr长度[0, maxLen-1],arr中的每个值[0, maxValue-1]
     */
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    /**
     * 返回一个数组，长度最大为maxSize，值最大为maxValue
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /**
     * 判断两个数组里面的值是否全部都相等
     * arr1和arr2一定等长
     */
    public static boolean equalValues(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断数组是否是有序的（升序）
     */
    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = arr[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int maxLen = 50;            //样本大小
        int maxValue = 1000;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
            int[] tmp = copyArray(arr1);
            selectionSort(arr1);
            if (!isSorted(arr1)) {
                System.out.println(Arrays.toString(tmp));       //如果选择排序有问题，备份arr1，打印出来
                System.out.println("选择排序错了！");
                break;
            }
        }

    }
}
