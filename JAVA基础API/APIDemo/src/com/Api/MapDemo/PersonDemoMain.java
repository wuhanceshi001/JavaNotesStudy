package com.Api.MapDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PersonDemoMain {
    public static void main(String[] args) {
        HashMap<Person, String> infoMap = new HashMap<>();
        infoMap.put(new Person("小强", 2), "御用名称");
        infoMap.put(new Person("小宏", 2), "胭红");
        infoMap.put(new Person("小美", 2), "御称");

        System.out.println(infoMap);

        Set<Map.Entry<Person, String>> entries = infoMap.entrySet();
        Iterator<Map.Entry<Person, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
