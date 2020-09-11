package com.designpatterns.pattern.decorator;

public class PremiumSound extends CarDecorator{

  private String premiumSound = "Harman Kardon";

  public PremiumSound(Car car) {
    this.car = car;
  }
  @Override
  public void assembly() {
    this.car.assembly();
    System.out.println("adding premium sound" + premiumSound);

  }
}
