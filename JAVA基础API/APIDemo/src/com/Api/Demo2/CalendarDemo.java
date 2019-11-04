package com.Api.Demo2;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
        Calendar now_calendar = Calendar.getInstance();
        System.out.println(now_calendar);
        System.out.println(now_calendar.get(Calendar.DATE));
        System.out.println(now_calendar.get(Calendar.DAY_OF_YEAR));
    }
}
