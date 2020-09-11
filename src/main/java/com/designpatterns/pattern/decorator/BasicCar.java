package com.designpatterns.pattern.decorator;

public class BasicCar implements Car {

  private final String wheels;
  private final String lights;
  private final String seats;

  public BasicCar(String wheels, String lights, String seats) {
    this.wheels = wheels;
    this.lights = lights;
    this.seats = seats;
  }

  @Override
  public void assembly() {
    System.out.println("assembly basic car with: " + this.toString());
  }

  @Override
  public String toString() {
    return "BasicCar{" +
            "wheels='" + wheels + '\'' +
            ", lights='" + lights + '\'' +
            ", seats='" + seats + '\'' +
            '}';
  }
}
