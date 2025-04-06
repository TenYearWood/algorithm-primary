package com.cy.class03;

/**
 *
 */
public class Code01_BSExist {

    /**
     *
     * 二分法查找
     * arr保证是有序的
     */
    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int L = 0;
        int R = arr.length - 1;
        // arr[0 .. N-1]  num  arr[L .. R] num
        while(L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    /**
     * 暴力测试，用于测试验证正确性，这个一定是正确的
     */
    public static boolean test(int[] sortedArr, int num) {
        for (int cur: sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 16, 16, 46, 51, 54, 55, 61, 71, 74, 75, 77, 77, 82, 82, 84, 84, 85, 98, 99, 131, 133, 134, 139, 144, 145, 146, 150, 151, 167, 170, 189, 193, 199};

        boolean exist = find(arr, 199);
        System.out.println(exist);
    }
}
