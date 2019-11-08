package com.ThreadDemo;

public class ThreadDemo {
    public static void main(String[] args) {

        new MyThread().start();

        new Thread(new MyRunner()).start();

        for (int i = 0; i <50; i++) {
//            System.out.println("主线程");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
