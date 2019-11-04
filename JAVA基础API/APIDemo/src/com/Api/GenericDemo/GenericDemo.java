package com.Api.GenericDemo;


import java.util.ArrayList;

public class GenericDemo {
    public static void main(String[] args) {

        Person<Integer> p = new Person(1);
        int name = p.getName();
        System.out.println(name);
    }


}

class Person<E>{

    private E name;

    public void setName(E name) {
        this.name = name;
    }

    public Person(E name) {
        this.name = name;
    }

    public E getName() {
        return name;
    }
}