package com.designpatterns.pattern.behavioral.observerWeatherStation;

public class TemperatureHumidityDisplay implements Observer, DisplayInfo {

  private Subject weatherData;
  private WeatherInfo weatherInfo;

  public TemperatureHumidityDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.register(this);
  }

  @Override
  public void update(WeatherInfo weatherInfo) {
    this.weatherInfo = weatherInfo;
    display();
  }

  @Override
  public void display() {
    System.out.println("Hello in TemperatureHumidityDisplay");
    System.out.println("TemperatureChanged: " + weatherInfo.getTemperature());
  }
}
