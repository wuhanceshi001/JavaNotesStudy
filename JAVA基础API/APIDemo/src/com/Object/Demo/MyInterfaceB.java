package com.Object.Demo;

public interface MyInterfaceB {

    public abstract void methodB();

    public abstract void methodCommon();

    public default void methodDefault(){

        System.out.println("接口A的默认方法");
    }
}
