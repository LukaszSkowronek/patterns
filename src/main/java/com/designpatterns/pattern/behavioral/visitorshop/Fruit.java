package com.designpatterns.pattern.behavioral.visitorshop;

public class Fruit implements Item{
    public Fruit(Integer pricePerKg, String name, Integer weight) {
        this.pricePerKg = pricePerKg;
        this.name = name;
        this.weight = weight;
    }

    private Integer pricePerKg;
    private String name;
    private Integer weight;

    public Integer getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(Integer pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
