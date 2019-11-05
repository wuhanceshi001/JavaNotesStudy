package com.Api.MapDemo;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(str);
        str = scanner.next();
        System.out.println(str);

        char[] chars = str.toCharArray();
        HashMap<Character, Integer> countChar = new HashMap<>();

        for (char aChar : chars) {
            if (countChar.containsKey(aChar)){
                Integer value = countChar.get(aChar);
                value++;
                countChar.put(aChar, value);
            }else{
                countChar.put(aChar, 1);
            }
        }
        System.out.println(countChar);


    }
}
