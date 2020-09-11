package com.designpatterns.pattern.structural.classadapter;

public class Client {

    public static void main(String[] args) {
        EmployeeAdapter employeeAdapter = new EmployeeAdapter();
        populateEmployee(employeeAdapter);
        BuissnessCard buissnessCard = new BuissnessCard();
        System.out.println(buissnessCard.getBuissnessCard(employeeAdapter));

    }

    public static void populateEmployee(Employee employee) {
        employee.setAddress("Warsaw");
        employee.setName("Lukasz");
    }

}
