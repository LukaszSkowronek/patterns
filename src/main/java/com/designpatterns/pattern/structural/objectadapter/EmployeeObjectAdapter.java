package com.designpatterns.pattern.structural.objectadapter;

import com.designpatterns.pattern.structural.classadapter.Customer;
import com.designpatterns.pattern.structural.classadapter.Employee;

public class EmployeeObjectAdapter implements Customer {

    Employee employee;

    public EmployeeObjectAdapter(Employee employee) {
        this.employee = employee;

    }
    @Override
    public String getFullName() {
        return employee.getName();
    }

    @Override
    public String getLocation() {
        return employee.getAddress();
    }
}
