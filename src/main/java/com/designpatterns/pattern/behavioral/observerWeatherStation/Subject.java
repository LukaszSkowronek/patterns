package com.designpatterns.pattern.behavioral.observerWeatherStation;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

  protected List<Observer> observers;

  public Subject() {
    this.observers = new ArrayList<>();
  }

  protected void register(Observer observer) {
    observers.add(observer);
  }

  protected void unregister(Observer observer) {
    observers.remove(observers.indexOf(observer));
  }

   abstract void notifyObservers();
}
