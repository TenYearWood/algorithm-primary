package com.cy.class06;

import java.util.ArrayList;
import java.util.Arrays;

public class ShowComparator {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].name + ", " + students[i].id + ", " + students[i].age);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 1, 4, 1, 6, 8, 4, 1, 5, 8, 2, 3, 0 };
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);

        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);

        Student[] students = { s1, s2, s3, s4, s5 };
        printStudents(students);
        System.out.println("=======");
        Arrays.sort(students, new IdComparator());
        printStudents(students);
        System.out.println("=======");

        ArrayList<Student> arrList = new ArrayList<>();
        arrList.add(s1);
        arrList.add(s2);
        arrList.add(s3);
        arrList.add(s4);
        arrList.add(s5);
        for (Student s : arrList) {
            System.out.println(s.name + ", " + s.id + ", " + s.age);
        }
        System.out.println("=======");
        arrList.sort(new IdComparator());
        for (Student s : arrList) {
            System.out.println(s.name + ", " + s.id + ", " + s.age);
        }
    }
}
