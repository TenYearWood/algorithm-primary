package com.cy.class02;

/**
 *
 */
public class Code02_RandToRand {

    public static void main(String[] args) {
        System.out.println("测试开始");

        /**
         * Math.random() -> double -> [0, 1) 左闭右开 等概率返回一个0.几的数
         * 等概率返回，看起来很神奇，因为数学上是做不到0~1等概率返回，而计算机里可以，为什么？
         * 因为计算机所有的小数都是有精度的，意味着0~1之间的小数不是无穷多的，是有穷尽的
         */
        int testTimes = 10000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.3) {
                count++;
            }
        }

        //System.out.println("出现了"+count+"次");
        System.out.println((double) count / (double) testTimes);    //0.2998836
        System.out.println("---------------------------------");

        /**
         * Math.random() * 8 之后变为：
         * [0, 1) -> [0, 8)
         * [0, 8)有：
         * 0.x
         * 1.x
         * ..
         * 7.x
         * 所以小于4的为 0.x ~ 3.x，概率为50%
         *
         * 表明：Math.random() * 8之后，[0, 8)之间的数也是等概率返回
         */
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 4) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);    //0.4999238


        /**
         * Math.random() * K 转成int之后表示的数范围：
         * [0, K) -> [0, K-1]
         *
         * counts[0]: 0出现的次数
         * counts[1]：1出现的次数
         * ..
         * counts[8]：8出现的次数
         *
         * 表明：(int) (Math.random() * K)之后，[0, K-1]之间的数也是等概率返回
         */
        int K = 9;
        int[] counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * K);    // [0, K-1]
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }


        System.out.println("---------------------------------");

        count = 0;
        double x = 0.7;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x, 2));
        System.out.println("---------------------------------");

        count = 0;
        x = 0.7;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower3() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x, 3));
        System.out.println("---------------------------------");

        // f2()：0,1等概率发生器测试
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) {
                count ++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println("---------------------------------");


        counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = f3();
            counts[num] ++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }
        System.out.println("---------------------------------");

        counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = g();
            counts[num] ++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }
    }

    /**
     * 返回[0,1)的一个小数
     * 任意的x，x属于[0,1), [0,x)范围上的数出现概率由原来的x调整成x平方
     *
     * 怎么做到的？
     * 是求最大值，max，分别调了两次随机行为，两次随机行为是独立的，怎么才能落到[0,x)范围上？
     * 只有两次行为都落在[0,x)上面才能返回[0,x)上，两次都命中这个范围，最终才能返回[0,x)范围上的数，所以是x²
     */
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    public static double xToXPower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }


    /**
     * f1()为题目中要求的等概率随机返回1~5之间的数。
     * lib中的，黑盒，不能改。只能调用。
     */
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 随机机制，只能用f1()
     * 等概率返回0和1
     */
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);

        /**
         * 1 2 返回0
         * 4 5 返回1
         * 根本没有返回3的时候
         */
        return ans < 3 ? 0 : 1;
    }

    /**
     * 得到000 ~ 111做到等概率返回
     * 0 ~ 7等概率返回
     */
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2() << 0);  //相当于 2² + 2¹ + 2º
    }

    /**
     * 0~6等概率返回
     * 调用f3，只要得到7就重做，保证只返回0~6
     */
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    /**
     * 1 ~ 7 等概率返回
     */
    public static int g() {
        return f4() + 1;
    }

    /**
     * x函数以0.84的概率返回0，1-0.84的概率返回1.
     * 你只能知道，x会以固定概率返回0和1，但是x的内容，你看不到。
     * 也就是你不知道x的内部返回0和1具体的固定概率是多少
     */
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * 等概率返回0和1
     * ans = x();  x做第一次，0或1
     * ans == x()  x做第二次, 0或1
     * 如果第二次等于第一次的值，那就重做。
     */
    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        // ans 0 1
        // ans 1 0
        return ans;
    }
}
