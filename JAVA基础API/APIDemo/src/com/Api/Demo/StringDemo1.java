package com.Api.Demo;

public class StringDemo1 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        char[] charArray = {'a', 'b', 'c'};
        String str3 = new String(charArray);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str1 == str2); // true
        System.out.println(str2 == str3); // False
        System.out.println(str2 == str3); // False
    }
}
