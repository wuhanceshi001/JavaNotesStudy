package com.Api.Demo;

import java.util.ArrayList;

public class ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(10); // 自动装箱
        intList.add(100);
        intList.add(1000);
        for (int num : intList // 自动拆箱
                ) {
            System.out.println(num);
        }
        arrayPrint(intList);
    }

    private static void arrayPrint(ArrayList<Integer> arrayList){

        System.out.print("{");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == arrayList.size()-1){
                System.out.println(arrayList.get(i) + "}");
            }else{
                System.out.print(arrayList.get(i) + "@");
            }
        }
    }

}
