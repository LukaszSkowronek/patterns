package com.designpatterns.pattern.behavioral.visitortax;

public interface Visitable {
    double accept(Visitor visitor);
}
