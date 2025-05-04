package com.cy.util;

/**
 * 用具类
 */
public class Util {

    /**
     * 将一个int类型的数打印成二进制数
     */
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }

    public static void main(String[] args) {
        int a = 0b00000000000000000000000001001100;     //76
        int b = 0b00000000000000000000000001000000;     //64
        int c = 0b00000000000000000000000000111111;     //63

        System.out.println(a % b);                      //12
        System.out.println(a & c);                      //12  即 1100
    }
}
