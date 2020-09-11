package com.designpatterns.pattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private static List<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {
        Employee employee = buildOrganization();
        Visitor visitor = new PrintVisitor();
        visitOrgStructure(employee, visitor);
        System.out.println("----------------");
        employees.forEach(
                e ->  e.accept(visitor)
        );

    }

    private static void visitOrgStructure(Employee emp, Visitor v) {
        emp.accept(v);
        emp.getDirectReports().forEach(e -> visitOrgStructure(e, v));
    }

    private static Employee buildOrganization() {

        Programmer p1 = new Programmer("Rachel", "C++");
        Programmer p2 = new Programmer("Andy", "Java");

        Programmer p3 = new Programmer("Josh", "C#");
        Programmer p4 = new Programmer("Bill", "C++");

        ProjectLead pl1 = new ProjectLead("Tina", p1, p2);
        ProjectLead pl2 = new ProjectLead("Joey", p3, p4);

        Manager m1 = new Manager("Chad", pl1);
        Manager m2 = new Manager("Chad II", pl2);

        VicePresident vp = new VicePresident("Richard", m1, m2);

        employees.add(p1);
        employees.add(p2);
        employees.add(p3);
        employees.add(p4);
        employees.add(pl1);
        employees.add(pl2);
        employees.add(m1);
        employees.add(m2);
        employees.add(vp);

        return vp;
    }


}
