package com.designpatterns.pattern.structural.objectadapter;

import com.designpatterns.pattern.structural.classadapter.BuissnessCard;
import com.designpatterns.pattern.structural.classadapter.Employee;

public class Client {
    public static void main(String[] args) {

        Employee employee = new Employee();
        populateEmployee(employee);
        EmployeeObjectAdapter employeeObjectAdapter = new EmployeeObjectAdapter(employee);
        BuissnessCard buissnessCard = new BuissnessCard();
        System.out.println(buissnessCard.getBuissnessCard(employeeObjectAdapter));

    }

    public static void populateEmployee(Employee employee) {
        employee.setAddress("Warsaw");
        employee.setName("Lukasz");
    }

}
