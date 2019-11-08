package com.ThreadDemo;

public class MyThread extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0; i <50 ; i++) {
//            System.out.println("子线程");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName());
        }
    }
}
