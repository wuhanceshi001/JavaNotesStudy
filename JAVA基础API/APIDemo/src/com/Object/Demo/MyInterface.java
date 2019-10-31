package com.Object.Demo;

public interface MyInterface extends MyInterfaceA, MyInterfaceB{
    public abstract void method();

    @Override
    default void methodDefault() {
        System.out.println("重写默认方法，default不能省略，因为我是默认方法");
    }
}
