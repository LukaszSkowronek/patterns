package com.designpatterns.pattern.singleton;

public class SingletonStaticClass {

    private SingletonStaticClass() {

    }


    private static class InnerSignelton {
        static SingletonStaticClass INSTANCE = new SingletonStaticClass();
    }

    public static SingletonStaticClass getInstance() {
        return InnerSignelton.INSTANCE;
    }
}
