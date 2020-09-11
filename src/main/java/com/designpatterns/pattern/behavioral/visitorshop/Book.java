package com.designpatterns.pattern.behavioral.visitorshop;

public class Book implements Item{
    private Integer price;
    private String name;

    public Book(Integer price, String name, String isbnNumber) {
        this.price = price;
        this.name = name;
        this.isbnNumber = isbnNumber;
    }

    private String isbnNumber;


    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
