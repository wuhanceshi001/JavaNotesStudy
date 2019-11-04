package com.Api.DouDiZhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DouDiZhu {
    public static void main(String[] args) {
        // 创建牌
        String[] colorList = {"♠", "♥", "♣", "♦"};
        String[] numList = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        ArrayList<String> pockerList = new ArrayList<>();

        for (String color : colorList
                ) {
            for (String num : numList
                    ) {
                pockerList.add(num + color);
            }
        }

        pockerList.add("大王");
        pockerList.add("小王");
//        System.out.println(pockerList);

        // 洗牌
        Collections.shuffle(pockerList);
//        System.out.println(pockerList);

        // 发牌
        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> keyPocker = new ArrayList<>();

        for (int i = 0; i < pockerList.size(); i++) {
            String p = pockerList.get(i);
            if (i >= 51) {
                keyPocker.add(p);
            } else if (i % 3 == 0) {
                player01.add(p);
            } else if (i % 3 == 1) {
                player02.add(p);
            } else if (i % 3 == 2) {
                player03.add(p);
            }
        }

        // 看牌
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(keyPocker);
        System.out.println("play01："+player01);
        System.out.println("play02："+player02);
        System.out.println("play03："+player03);
        System.out.println("底牌："+keyPocker);
    }
}
