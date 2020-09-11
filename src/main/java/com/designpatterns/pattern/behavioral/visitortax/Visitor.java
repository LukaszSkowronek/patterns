package com.designpatterns.pattern.behavioral.visitortax;

public interface Visitor {
    double visit(Alcohol alcohol);
    double visit(FastFood fastFood);
    double visit(Necessity necessity);
}
