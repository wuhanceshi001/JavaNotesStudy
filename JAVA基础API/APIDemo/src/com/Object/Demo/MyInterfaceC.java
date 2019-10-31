package com.Object.Demo;

public interface MyInterfaceC {

    public abstract void methodC();

    public abstract void methodCommon();

    public default void methodDefault(){

        System.out.println("接口C的默认方法");
    }
}
