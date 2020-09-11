package com.designpatterns.pattern.decorator;

public class Client {

  public static void main(String[] args) {
    Car car = new PremiumSound(new Navigation(new BasicCar("big wheegls", "LED", "Electric Seats")));

    car.assembly();
  }
}
