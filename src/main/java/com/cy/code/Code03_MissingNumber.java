package com.cy.code;

/**
 * 找到缺失的数字
 * 给定一个长度为n的数组arr，值一定都在[0, n]范围上，并且没有重复值
 * 那么[0, n]范围上一定缺了某个数字，找到这个缺失的数字
 * 测试连接：https://leetcode.cn/problems/missing-number/
 */
public class Code03_MissingNumber {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4, 5, 0};
        System.out.println(missingNumber(a));
    }

    public static int missingNumber(int[] nums) {
        int eorAll = 0, eorHas = 0;
        for (int i = 0; i < nums.length; i++) {
            eorAll ^= i;
            eorHas ^= nums[i];
        }

        eorAll ^= nums.length;
        return eorAll ^ eorHas;
    }
}
