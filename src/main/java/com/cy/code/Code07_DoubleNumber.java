package com.cy.code;

/**
 * 找到唯二出现奇数次的数
 * 数组中有两种数出现了奇数次，其他的数都出现了偶数次
 * 返回这两种出现了奇数次的数
 * 测试连接:https://leetcode.cn/problems/single-number-iii/
 */
public class Code07_DoubleNumber {

    public static int[] doubleNumber(int[] nums) {
        int eor1 = 0;
        for (int num : nums) {
            //nums中有2种数a、b出现了奇数次，其他的数都出现了偶数次
            eor1 ^= num;
        }
        // eor1: a ^ b
        // 提取出二进制里最右侧的1
        // eor1:        0 1 1 0 1 0 0 0
        // rightOne:    0 0 0 0 1 0 0 0
        int rightOne = eor1 & (-eor1);
        int eor2 = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                eor2 ^= num;
            }
        }
        return new int[] { eor2, eor1 ^ eor2};
    }
}
