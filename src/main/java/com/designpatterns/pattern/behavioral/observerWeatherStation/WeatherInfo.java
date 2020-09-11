package com.designpatterns.pattern.behavioral.observerWeatherStation;

public class WeatherInfo {
  private int temperature;
  private String humidity;
  private int wind;

  public WeatherInfo(int temperature, String humidity, int wind) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.wind = wind;
  }

  public int getTemperature() {
    return temperature;
  }

  public String getHumidity() {
    return humidity;
  }

  public int getWind() {
    return wind;
  }
}
