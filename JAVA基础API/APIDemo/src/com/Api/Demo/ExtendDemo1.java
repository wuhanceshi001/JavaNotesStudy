package com.Api.Demo;

public class ExtendDemo1 {
    public static void main(String[] args) {
        new Zi1();
    }
}

class Fu1{
    Fu1(){
        System.out.println("Fu1初始化");
    }
}

class Zi1 extends Fu1{
    Zi1(){
        super();
        System.out.println("Zi1初始化");
    }
}
