package com.cy.code;

/**
 * int类型的数为4字节，1字节=8bit，所以int类型的数为32位
 */
public class Code01_BinarySystem {

    public static void printBinary(int num) {
        for (int i = 31; i >= 0 ; i--) {
            System.out.print(((num >> i) & 1) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //非负数
        int a = 78;
        System.out.println(a);
        printBinary(a);
        System.out.println("=============a===============");

        //负数
        int b = -6;
        System.out.println(b);
        printBinary(b);
        System.out.println("=============b===============");

        //直接写二进制的形式定义变量
        int c = 0b1001110;
        System.out.println(c);
        printBinary(c);
        System.out.println("=============c===============");

        //直接写十六进制的形式定义变量
        // 0100 -> 4
        // 1110 -> e
        // 0x4e -> 01001110
        int d = 0x4e;
        System.out.println(d);
        printBinary(d);
        System.out.println("=============d===============");

        /**
         * ~、取反
         * 相反数都是 取反 + 1，不管正负都是这样算的
         * 但是任何数字都可以转成与之对应的相反数吗？不是的，比如-8为1000，就转不了。转了之后还是它自己
         */
        System.out.println(a);
        printBinary(a);
        printBinary(~a);
        int e = ~a + 1;     //等同于 -a
        System.out.println(e);
        printBinary(e);
        System.out.println("=============e===============");

        //ing long 的最小值，取相反数、绝对值，都是自己
        int f = Integer.MIN_VALUE;
        System.out.println(f);
        printBinary(f);
        System.out.println(-f);
        printBinary(-f);
        System.out.println(~f + 1);
        printBinary(~f + 1);
        System.out.println("=============f===============");

        /**
         * | & ^
         * | : 或，两位里面有1个是1，就能得到1
         * &： 与，两位里面都是1，才能得到1，否则得到0
         * ^:  异或，不同为1，相同为0
         */
        int g = 0b0001010;
        int h = 0b0001100;
        printBinary(g | h);     //00000000000000000000000000001110
        printBinary(g & h);     //00000000000000000000000000001000
        printBinary(g ^ h);     //00000000000000000000000000000110
        System.out.println("=============g,h===============");

        /**
         * <<
         */
        int i = 0b0011010;
        printBinary(i);
        printBinary(i << 1);
        printBinary(i << 2);
        printBinary(i << 3);
        System.out.println("=============i <<===============");

        /**
         * 非负数 >> >>> 效果一样
         */
        printBinary(i);
        printBinary(i >> 2);
        printBinary(i >>> 2);
        System.out.println("=============i >> >>>===============");

        /**
         * 负数 >> >>> 效果不一样
         */
        int j = 0b11110000000000000000000000000000;
        printBinary(j >> 2);
        printBinary(j >>> 2);
        System.out.println("=============j >> >>>===============");

        /**
         * 非负数 << 1，等同于乘以2
         * 非负数 << 2，等同于乘以4
         * 非负数 << 3，等同于乘以8
         * 非负数 << i，等同于乘以2的i次方
         * ...
         * 非负数 >> 1，等同于除以2
         * 非负数 >> 2，等同于除以4
         * 非负数 >> 3，等同于除以8
         * 非负数 >> i，等同于除以2的i次方
         * 只有非负数符合这个特征，负数不要用
         */
        int k = 10;
        System.out.println(k);
        System.out.println(k << 1);
        System.out.println(k << 2);
        System.out.println(k << 3);
        System.out.println(k >> 1);
        System.out.println(k >> 2);
        System.out.println(k >> 3);
        System.out.println("=============k===============");
    }
}
