package com.Api.MapDemo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> infoMap = new LinkedHashMap<>();

        infoMap.put("b", "小明");
        infoMap.put("a", "12");
        infoMap.put("c", "128");

        System.out.println(infoMap);
        Set<Map.Entry<String, String>> entries = infoMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


    }
}
