package com.designpatterns.pattern.behavioral.visitortax;

public class Alcohol implements Visitable {
    public Double getPrice() {
        return price;
    }

    private Double price;

    public Alcohol(Double price) {
        this.price = price;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
