package com.designpatterns.pattern.behavioral.visitorshop;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Book(10, "W pustyni i w puszczy", "21331vdsv"));
        items.add(new Book(50, "100 twarzy greya", "dsadsa2314sa"));
        items.add(new Fruit(15, "pomidor", 1));
        items.add(new Fruit(5, "ziemniak", 10));
        int total = calculatePrice(items);
        System.out.println("Total Cost = " + total);
    }

    private static int calculatePrice(List<Item> items) {
        Visitor visitor = new NewCalculator();
        int sum = 0;
        for (Item item : items) {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }
}
