package com.ThreadDemo;
public class NoNameThread {

    public static void main(String[] args){

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <50 ; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        }).start();

        new Thread(){
            @Override
            public void run(){

                for (int i = 0; i <50 ; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread类的形式");
                }
            }
        }.start();

        for (int i = 0; i <50 ; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程");
        }



    }
}
