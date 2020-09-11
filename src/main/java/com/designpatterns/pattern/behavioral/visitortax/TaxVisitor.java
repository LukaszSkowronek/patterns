package com.designpatterns.pattern.behavioral.visitortax;

public class TaxVisitor implements Visitor {
    @Override
    public double visit(Alcohol alcohol) {
        double tax = alcohol.getPrice()*0.32;
        System.out.println("Tax for alcohol: " + tax);
        return tax;
    }


    @Override
    public double visit(FastFood fastFood) {
        double tax = fastFood.getPrice()*0.18;
        System.out.println("Tax for fastFood: " + tax);
        return tax;
    }

    @Override
    public double visit(Necessity necessity) {
        double tax = necessity.getPrice()*0;
        System.out.println("Tax for necessity: " + tax);
        return tax;
    }
}
