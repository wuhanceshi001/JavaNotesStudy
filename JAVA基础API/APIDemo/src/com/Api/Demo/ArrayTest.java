package com.Api.Demo;

import java.util.ArrayList;
import java.util.Random;

public class ArrayTest {
    public static void main(String[] args) {
        // 生成6个1~33之间的随机整数,添加到集合,并遍历
        Random r1 = new Random();
        ArrayList<Integer> listInt = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            listInt.add(r1.nextInt(32) + 1);
        }

//        for (int i = 0; i < listInt.size(); i++) {
//            System.out.println(listInt.get(i));
//        }
        for (Integer num:listInt
             ) {
            System.out.println(num);
        }
    }
}
