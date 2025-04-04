package com.cy.code;

/**
 * 找到唯一出现奇数次的数
 * 数组中1种数出现了奇数次，其他的数都出现了偶数次
 * 返回出现了奇数次的数
 * 测试连接：https://leetcode.cn/problems/single-number/
 */
public class Code06_SingleNumber {

    public static int singleNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        return eor;
    }
}
