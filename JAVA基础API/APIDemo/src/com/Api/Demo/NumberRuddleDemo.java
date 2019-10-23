package com.Api.Demo;

import java.util.Random;
import java.util.Scanner;

public class NumberRuddleDemo {
    public static void main(String[] args){
        Random r = new Random();

        int num = r.nextInt(100) + 1;

        while (true){
            System.out.println("请输入您猜的数字1-100：");
            int temp = new Scanner(System.in).nextInt();
            if (temp > num){
                System.out.println("猜大了...");
            }else if(temp < num){
                System.out.println("猜小了...");
            }else{
                System.out.println("恭喜你猜对了" + num);
                break;
            }
        }
    }
}
