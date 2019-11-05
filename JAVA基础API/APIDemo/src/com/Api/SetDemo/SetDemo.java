package com.Api.SetDemo;

import java.util.HashSet;
import java.util.Iterator;

public class SetDemo {
    public static void main(String[] args) {
        HashSet<Integer> h = new HashSet<>();
        h.add(2);
        h.add(1);
        h.add(3);
        h.add(2);
        h.add(1);
        System.out.println(h);
        Iterator<Integer> i = h.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        for (Integer integer : h) {
            System.out.println(integer);
        }

        for (Integer integer: h) {
            System.out.println(integer);
        }
        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());//1179395
    }
}
