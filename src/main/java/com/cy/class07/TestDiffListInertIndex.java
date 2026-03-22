package com.cy.class07;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 测试ArrayList和linkedList都在0位置插入元素的性能表现测试
 */
public class TestDiffListInertIndex {

    /**
     * 测试ArrayList和linkedList中插元素但是每个元素都是插在0位置。
     * 测试两个list的耗时性能
     */
    public static void main(String[] args) {
        int testTime = 100000;
        long start;
        long end;

        ArrayList<Integer> arr1 = new ArrayList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            arr1.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);        //515

        LinkedList<Integer> arr2 = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            arr2.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);        //5
    }
}
