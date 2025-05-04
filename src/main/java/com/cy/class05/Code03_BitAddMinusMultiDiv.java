package com.cy.class05;

/**
 * 位运算实现+-*\\/
 * 测试连接：https://leetcode.com/problems/divide-two-integers
 */
public class Code03_BitAddMinusMultiDiv {

    public static int add(int a, int b) {
        int sum = a;
        while(b != 0) {
            sum = a ^ b;            //无进位相加信息   ->  sum
            b = (a & b) << 1;       //进位信息  -> b   ->  b'
            a = sum;                //无进位相加信息a  ->  a'
        }
        return sum;
    }

    /**
     * 返回n的相反数
     * 相反数 = 取反 + 1
     * -n = ~n + 1
     */
    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b){
        return add(a, negNum(b));
    }

    /**
     * 乘法
     *
     * 右移：
     * b >> 1，表示右移1，最高位拿符号位来补。
     * b >>>1, 表示右移1，最高位一律拿0来补。
     *
     * 支持负数，道理不好解释，负数的情况下到底发生了什么，跟补码有关，你只要知道同样这套方法既支持正数也支持负数。
     */
    public static int multi(int a, int b) {
        int res = 0;
        while(b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    /**
     * 除法
     *
     * 这个方法在正式开始之前，a和b一定要都转成正数
     *
     * x是非负的，第32位是符号位，肯定是0，所以没必要右移31位。所以for循环i从30开始。
     *
     * 这里^的运算是：非短路逻辑异或，两边的表达式都会执行
     * boolean a = true, b = false;
     * boolean c = a ^ b; // true（不同时为 true/false）
     * 如果需要逻辑异或（对布尔没必要值），直接用 != 更直观： boolean xor = (a != b); // 等效于 a ^ b
     *
     * a ^ b: a和b不同返回true，否则返回false
     *
     * 这个除法必须要求x和y转成正数的形式。
     * 这个方法一定是要能把a和b转成正数才能继续算，但系统最小值没办法转绝对值，所以有局限。
     */
    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        // x / y
        for (int i=30; i>=0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        //如果a和b符号不一样，取个负号返回；如果a和b负号一样，直接返回答案
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static void main(String[] args) {
        int a = 7;
        int b = -3;
        System.out.println(multi(a, b));
    }

}
