package com.designpatterns.pattern.singleton;

public class Client {
    public static void main(String[] args) {
        SingletonStaticClass singletonStaticClass = SingletonStaticClass.getInstance();
        SingletonStaticClass singletonStaticClass1 = SingletonStaticClass.getInstance();

        System.out.println(singletonStaticClass == singletonStaticClass1);
    }
}
