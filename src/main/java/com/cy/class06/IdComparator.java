package com.cy.class06;

import java.util.Comparator;

/**
 * id比较器，谁id大，谁放前
 */
public class IdComparator implements Comparator<Student> {

    // 如果返回负数，认为第一个参数应该排在前面
    // 如果返回正数，认为第二个参数应该排在前面
    // 如果返回0，认为谁放前面无所谓
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.id < o2.id) {
            return 1;
        } else if (o2.id < o1.id) {
            return -1;
        } else {
            return 0;
        }
    }
}
