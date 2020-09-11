package com.designpatterns.pattern.structural.classadapter;

public class BuissnessCard {

    public String getBuissnessCard(Customer customer) {
        String buissnessCard = "Name: " + customer.getFullName()
                + "Location: " + customer.getLocation();
        return buissnessCard;
    }
}
