package com.Api.CompareDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainDemo {
    public static void main(String[] args) {
        personDemo();

        studentDemo();
    }

    private static void studentDemo() {

        Student s1 = new Student("a小红", 14);
        Student s2 = new Student("b小红", 14);
        Student s3 = new Student("c小红", 17);
        Student s4= new Student("d小红", 13);

        ArrayList<Student> stuList = new ArrayList<>();

        stuList.add(s1);
        stuList.add(s2);
        stuList.add(s3);
        stuList.add(s4);

        System.out.println(stuList);

        Collections.sort(stuList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o1.getAge() - o2.getAge();
                if (result==0){
                    result = o1.getName().charAt(0) - o1.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println(stuList);
    }

    private static void personDemo() {
        Person p1 = new Person("小明", 12);
        Person p2 = new Person("小宏", 18);
        Person p3 = new Person("亮子", 10);
        Person p4 = new Person("小刚", 20);

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        System.out.println(personList);

        Collections.sort(personList);
        System.out.println(personList);
    }
}
