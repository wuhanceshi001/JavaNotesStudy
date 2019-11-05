package com.Api.SetDemo;

import java.util.HashSet;

public class HashDemo {
    public static void main(String[] args) {
        Person p1 = new Person("小明", 18);
        Person p2 = new Person("小明", 18);
        Person p3 = new Person("小宏", 18);

        HashSet<Person> peopleHashSet = new HashSet<>();
        peopleHashSet.add(p3);
        peopleHashSet.add(p1);
        peopleHashSet.add(p2);


        for (Person person : peopleHashSet) {
            System.out.println(person);
        }
    }
}
