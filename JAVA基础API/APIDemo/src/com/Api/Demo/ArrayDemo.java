package com.Api.Demo;

import java.util.ArrayList;

public class ArrayDemo {

    public static void main(String[] args) {
        // 首先创建一个长度为3的数组，存储Person对象
//        Person[] array = new Person[3];
        ArrayList<Person> personList = new ArrayList<>();
//        System.out.println(array[0]);

        Person p1 = new Person("小明", 18);
        Person p2 = new Person("小宏", 18);
        Person p3 = new Person("旺财", 18);
//        array[0] = p1;
//        array[1] = p2;
//        array[2] = p3;
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p3);
        System.out.println(personList);
        System.out.println(personList.size());
//        System.out.println(array[0].getName());
//        System.out.println(array[1].getName());
//        System.out.println(array[2].getName());

//        for(int i=0; i<array.length; i++){
//            System.out.println(array[i].getName());
//        }

        for (Person p: personList
             ) {
            System.out.println(p.getName());
        }
        Person personTemp = personList.get(2);
        System.out.println(personTemp.getName());
        System.out.println("**********************");
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).getName());
        }

    }
}
