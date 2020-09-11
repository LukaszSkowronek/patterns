package com.designpatterns.pattern.behavioral.visitorshop;

public class NewCalculator implements Visitor {
    @Override
    public int visit(Book b) {
        return 0;
    }

    @Override
    public int visit(Fruit b) {
        return 0;
    }
}
