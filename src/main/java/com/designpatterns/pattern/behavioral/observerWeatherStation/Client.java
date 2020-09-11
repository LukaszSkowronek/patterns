package com.designpatterns.pattern.behavioral.observerWeatherStation;

public class Client {

  public static void main(String[] args) {
    try {
      new Client().perform();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  public void perform() throws InterruptedException {
    WeatherInfo weatherInfo = new WeatherInfo(10, "50%", 30);
    WeatherData weatherData = new WeatherData(weatherInfo);


    TemperatureHumidityDisplay temperatureHumidityDisplay = new TemperatureHumidityDisplay(weatherData);

    weatherData.setWeatherInfo(new WeatherInfo(20, "32%", 50));
    Thread.sleep(5000);
    weatherData.setWeatherInfo(new WeatherInfo(30, "32%", 50));
  }
}
