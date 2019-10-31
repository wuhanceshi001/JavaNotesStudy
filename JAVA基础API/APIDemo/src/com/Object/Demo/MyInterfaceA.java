package com.Object.Demo;

public interface MyInterfaceA {

    public abstract void methodA();

    public abstract void methodCommon();

    public default void methodDefault(){
        System.out.println("接口A的默认方法");
    }
}
