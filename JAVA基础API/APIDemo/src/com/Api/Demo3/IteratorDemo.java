package com.Api.Demo3;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        ArrayList<String> strArray = new ArrayList<>();
        strArray.add("木头");
        strArray.add("草堆");
        strArray.add("兔子");
        System.out.println(strArray);

        ArrayList<Integer> intArray = new ArrayList<>();

        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);

        Iterator<String> iteratorStr = strArray.iterator();

        while (iteratorStr.hasNext()){
            String el = iteratorStr.next();
            System.out.println(el);
        }
        for (String str:strArray
             ) {
            System.out.println(str);
        }

        for (int x: intArray
             ) {
            System.out.println(x);
        }

        Iterator<Integer> intIterator = intArray.iterator();
        while (intIterator.hasNext()){
            System.out.println(intIterator.next());
        }
    }
}
