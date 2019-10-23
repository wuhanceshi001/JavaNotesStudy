package com.Api.Demo;

import java.util.Scanner;

public class HelloWorld {


    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println("你好，世界");

        // Scanner 类演练
        Scanner sc = new Scanner(System.in);
        System.out.println("用户输入的整数是：" + sc.nextInt());
        my_add();
        my_max();


    }
    private static void my_add() {
        Scanner sc1 = new Scanner(System.in);
        int num1 = sc1.nextInt();
        Scanner sc2 = new Scanner(System.in);
        int num2 = sc2.nextInt();
        System.out.println(num1 + num2);

    }

    private static void my_max() {
        int num1 = new Scanner(System.in).nextInt();
        int num2 = new Scanner(System.in).nextInt();
        int num3 = new Scanner(System.in).nextInt();
        int temp = (num1 > num2) ? num1 : num2;
        int max = (temp > num3) ? temp : num3;
        System.out.println(max);
    }

}

