package com.designpatterns.pattern.objectpool;

import java.awt.geom.Point2D;

public class BitMap implements Image {
    private String name;

    private Point2D location;

    BitMap(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Bitman name : " + name);
    }

    @Override
    public Point2D getLocation() {
        return null;
    }

  @Override
  public void setLocation(Point2D location) {

  }

    @Override
    public void reset() {
        location = null;
        System.out.println("Reseting state");
    }
}
