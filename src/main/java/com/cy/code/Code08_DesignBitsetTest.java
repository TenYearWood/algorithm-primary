package com.cy.code;

/**
 * 位图的实现
 * Bitset是一种能以紧凑形式存储位的数据结构
 * Bitset(int n): 初始化n个位，所有位都是0
 * void fix(int i): 将下标i的位上的值更新为1
 * void unfix(int i): 将下标i的位上的值更新为0
 * void flip(): 翻转所有位的值
 * boolean all(): 是否所有的位都是1
 * boolean one(): 是否至少有一位是1
 * int count(): 返回所有位中1的数量
 * String toString(): 返回所有位的状态
 * 测试连接：https://leetcode-cn.com/problems/design-bitset/
 */
public class Code08_DesignBitsetTest {


    class Bitset {
        private int[] set;
        private final int size;
        private int zeros;
        private int ones;
        private boolean reverse;

        public Bitset(int n) {
            set = new int[(n + 31) / 32];
            size = n;
            zeros = n;
            ones = 0;
            reverse = false;
        }


    }
}
