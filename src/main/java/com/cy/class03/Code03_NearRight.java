package com.cy.class03;

import java.util.Arrays;

/**
 * 有序数组中找到<=num最右的位置
 */
public class Code03_NearRight {

    public static int mostRightLessNumIndex(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int t = -1;     //记录最晚出现<=num的位置

        while(L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] <= num) {
                t = mid;
                L = mid + 1;
            } else {
                R= mid - 1;
            }
        }
        return t;
    }

    // for test
    public static int test(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != mostRightLessNumIndex(arr, value)) {
                printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(mostRightLessNumIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
