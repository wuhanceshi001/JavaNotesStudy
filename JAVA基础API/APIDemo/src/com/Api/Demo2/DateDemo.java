package com.Api.Demo2;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        demo1();
        demo2();
    }

    private static void demo2() {
        Date date = new Date(0L);
        System.out.println(date);
        System.out.println(date.getTime());
    }

    private static void demo1() {
        Date date = new Date(); // 返回当前时间对象
        System.out.println(date);
        System.out.println(date.getTime());
    }
}
