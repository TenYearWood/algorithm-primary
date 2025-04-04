package com.cy.code;

/**
 * 给定一个参数N，
 * 返回：1! + 2! + 3! + 4! + ... + N!的结果
 *
 * B同学的算法更好
 */
public class Code01_SumOfFactorial {

    /**
     * 小A同学f1的算法，从1~N，每个数的阶乘都算一遍，最后累加
     */
    public static long f1(int N) {
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += factorial(i);
        }
        return ans;
    }

    public static long factorial(int N) {
        long ans = 1;
        for (int i = 1; i <= N ; i++) {
            ans *= i;
        }
        return ans;
    }

    /**
     * B同学的算法，临时变量保存上一次阶乘计算的结果，下一次的阶乘=上一次结算的结果基础上再乘以一个数
     * 每次累加计算后的阶乘
     * 一个for循环就搞定了
     */
    public static long f2(int N) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }

}
