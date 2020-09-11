package com.designpatterns.pattern.behavioral.visitortax;

public class FastFood implements Visitable {
    private Double price;

    public FastFood(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
