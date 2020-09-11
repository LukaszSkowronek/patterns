package com.designpatterns.pattern.behavioral.visitortax;

public class Client {

    public static void main(String[] args) {

        Alcohol alcohol = new Alcohol(30.0);
        FastFood fastFood = new FastFood(10.0);
        Necessity necessity = new Necessity(70.0);
        Visitor visitor = new TaxVisitor();

        // normal tax
        alcohol.accept(visitor);
        fastFood.accept(visitor);
        necessity.accept(visitor);

        System.out.println("--------");
        //holiday tax
        visitor = new HolidayTaxVisitor();
        alcohol.accept(visitor);
        fastFood.accept(visitor);
        necessity.accept(visitor);



    }
}
