package com.designpatterns.pattern.behavioral.observerWeatherStation;

public class WeatherData extends Subject{

  private WeatherInfo weatherInfo;

  public WeatherData(WeatherInfo weatherInfo) {
    this.weatherInfo = weatherInfo;
  }


  public void meseurmentsChanged() {
    notifyObservers();
  }

  @Override
  void notifyObservers() {
      observers.forEach(
              o -> o.update(weatherInfo)
      );
  }


  public void setWeatherInfo(WeatherInfo weatherInfo) {
    this.weatherInfo = weatherInfo;
    meseurmentsChanged();
  }
}
