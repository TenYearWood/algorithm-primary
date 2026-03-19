package com.cy.class06;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ShowComparator2 {

    public static class MyComparator implements Comparator<Integer> {

        /**
         * 负，第一个参数放前
         * 正，第二个参数放前
         * 0，无所谓，表示相等
         */
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        test4();
    }

    /**
     * PriorityQueue: 小根堆，优先级队列，从小到大排好序的，而且代价非常的好，logN级别
     * 这里默认是基础类型，默认是小根堆，但是我现在希望是大根堆，动态加入数字，最大的在前面，弹出一个之后，次大的顶上来，怎么做？
     * 可以自己实现比较器来完成。
     */
    public static void test1() {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(6);
        heap.add(2);
        heap.add(3);
        heap.add(1);
        heap.add(7);
        System.out.println(heap.peek());
        heap.add(0);
        System.out.println(heap.peek());

        while(!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }

    /**
     * 大根堆，传入比较器，告诉它不用默认的比较器。这个结构出来之后，大数在前
     */
    public static void test2() {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComparator());
        heap.add(6);
        heap.add(2);
        heap.add(3);
        heap.add(1);
        heap.add(7);
        while(!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }

    /**
     * 传入自定义的javaBean，内部按照IdComparator的规则排序
     * PriorityQueue，是跟有序有关的结构，都可以这么干
     * 还有哪些跟有序有关的结构？treeMap，treeSet
     *
     * treeSet，底层是红黑树
     *
     * 比较器是干嘛的？系统自带的排序或者系统自带的结构，如果它天然要求有序的东西，只要自己定义好怎么比大小，直接可以用系统提供的来。
     */
    public static void test3() {
        PriorityQueue<Student> heap = new PriorityQueue<>(new IdComparator());
        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        while(!heap.isEmpty()) {
            Student s = heap.poll();
            System.out.println(s.name + ", " + s.id + ", " + s.age);
        }

        /**
         * TreeSet里面的对象必须是可以比较的，在这个有序的结构中，它就会按照你给定的比较器这个比较预期去排序。
         */
        TreeSet<Student> treeSet = new TreeSet<>(new IdComparator());
    }

    /**
     * String字符串是按照字典序来排序的，所有语言都一样
     * 1) 如果比较的两个字符串是等长的，直接按照数字来进行比较。abc 和 bck，比较第1个字符，a的ascii码小于b的ascii码，所以abc < bck
     * 2) 对于长度不一样的，比如abc 和 b比较，短的补成和长的一样长，拿最低的ascii码来补，补完之后两个再比。补完序后：abc < b00
     */
    public static void test4() {
        String str1 = "abc";
        String str2 = "abd";
        System.out.println(str1.compareTo(str2));       // -1
    }
}
