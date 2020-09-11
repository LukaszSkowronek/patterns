package com.designpatterns.pattern.structural.classadapter;

public class EmployeeAdapter extends Employee implements Customer {
    @Override
    public String getFullName() {
        return this.getName();
    }

    @Override
    public String getLocation() {
        return this.getAddress();
    }
}
