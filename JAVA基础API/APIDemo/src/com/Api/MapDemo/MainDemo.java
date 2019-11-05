package com.Api.MapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MainDemo {
    public static void main(String[] args) {

//        demo1();

        demo2();

    }

    private static void demo2() {
        HashMap<String, Object> studentsInfo = new HashMap<>();

        studentsInfo.put("name", "小强");
        studentsInfo.put("age", 18);
        studentsInfo.put("height", 178.12);
        studentsInfo.put("weight", 63.11);

        System.out.println(studentsInfo);

        Set<Map.Entry<String, Object>> entries = studentsInfo.entrySet();
        for(Map.Entry<String, Object> people : entries){
            System.out.println(people.getKey() + ":" + people.getValue());
        }


    }

    private static void demo1() {
        HashMap<String, Object> pp = new HashMap<>();

        pp.put("name", "小明");
        pp.put("age", 18);
        pp.put("height", 60.5);

        System.out.println(pp);

        // 遍历
        Set<String> keys = pp.keySet();
        for (String key : keys) {
            Object value = pp.get(key);
            System.out.println(value);
        }
    }
}
