package com.check;

public interface InterfaceA {

    default void setThis() {
        System.out.println("Interface A");
    }
}
