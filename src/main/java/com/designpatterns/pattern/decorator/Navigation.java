package com.designpatterns.pattern.decorator;

public class Navigation extends CarDecorator{

  private String navigation = "GPS navigation";

  public Navigation(Car car) {
    this.car = car;
  }

  @Override
  public void assembly() {
    car.assembly();
    System.out.println("Adding navigation " + navigation);
  }
}
