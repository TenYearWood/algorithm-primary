package com.cy.code;

/**
 * 打印二进制数
 */
public class Code00_PrintBinary {

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a = -8;
        print(a);
        print(-a);
        print(~a + 1);
    }
}
