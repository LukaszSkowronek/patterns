package com.designpatterns.pattern.behavioral.visitorshop;

public interface Visitor {

    int visit(Book b);
    int visit(Fruit b);
}
