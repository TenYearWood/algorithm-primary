package com.cy.class07;

/**
 * 测试值传递
 */
public class TestValueSend {

    public static void main(String[] args) {
        int num = 10;
        System.out.println("Before: " + num); // 输出 Before: 10
        increment(num); // 注意这里传递的是num的副本，num的值不会改变
        System.out.println("After: " + num); // 输出 After: 10
    }

    public static void increment(int number) {
        number = number + 1; // 这里改变的是number的副本，不影响原始的num变量
    }
}
