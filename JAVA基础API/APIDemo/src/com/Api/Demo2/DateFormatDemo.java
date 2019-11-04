package com.Api.Demo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {
    public static void main(String[] args) throws ParseException {
        demo1();
    }

    private static void demo1() throws ParseException {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str_time = simpleDate.format(date);
        System.out.println(str_time);
        Date date2 = simpleDate.parse("2019-11-03 12:09:56");
        System.out.println(date2);
    }
}
