package com.cy.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @description com.cy.util
 * @author: chengyu
 * @date: 2026-03-28 14:17
 */
public class JustTest {


    public static void main(String[] args) {
        test2();
    }

    public static void test2() {
        List<Person> l1 = new ArrayList<>();
        l1.add(new Person("zhangsan"));
        System.out.println("l1:" + l1);

        List<Person> l2 = new ArrayList<>(l1);
        System.out.println("l2:" + l2);
        System.out.println("==============================");

        l1.add(new Person("wangwu"));
        System.out.println("l1:" + l1);
        System.out.println("l2:" + l2);
        System.out.println("==============================");

        l1.get(0).setName("heihei");
        System.out.println("l1:" + l1);
        System.out.println("l2:" + l2);
    }

    /**
     * 对 list1 的结构修改（如添加、删除元素）不会影响 list2，因为它们是两个独立的列表。
     * list1 中元素内容的修改（如果元素是可变对象）可能会影响 list2，因为它们共享对象引用；但对于 Integer 这类不可变对象，这种情况不会发生。
     */
    public static void test1() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        System.out.println("list1:" + list1);

        List<Integer> list2 = new ArrayList<>(list1);
        list1.add(2);
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
    }
}
