package com.designpatterns.pattern.behavioral.visitorshop;

public interface Item {

    int accept(Visitor visitor);
}
