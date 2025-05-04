package com.cy.class05;

import java.util.HashSet;

/**
 * 位图的实现
 */
public class Code02_BitMap2 {

    public static class BitMap {
        private long[] bits;

        /**
         * (max + 64) >> 6 -> (max + 64) / 64
         * 右移6位就是除64的意思
         */
        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];
        }

        /**
         * num >> 6 -> num / 64，定位到bit数组对应下标的整数
         * num % 64 怎么写？
         * num % 64 -> num & 63
         *
         * 这里1L不能写成1，假设加170这个数，1左移42位，系统认为1是int类型，只有32位，左移就不对了。
         */
        public void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    /**
     * 测试方法
     * bitMap：上面写的位图
     * set：哈希表
     * 以1/3的概率，两个共同加一个数
     * 以1/3的概率，两个共同删一个数
     * 再以1/3概率，你两共同查一个数
     * 最后吧所有从0~max的数查一遍，有任何一点对应不上打印Oops
     */
    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }
}
