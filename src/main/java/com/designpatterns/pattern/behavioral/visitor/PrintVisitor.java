package com.designpatterns.pattern.behavioral.visitor;

public class PrintVisitor implements Visitor {
    @Override
    public void visit(Programmer p) {
        System.out.println("Prograamer: " + p.getName() + " with skills " + p.getSkill());
    }

    @Override
    public void visit(ProjectLead pl) {
        System.out.println("Projectlead: " + pl.getName() + " leading " + pl.getDirectReports().size() + " Programmers");

    }

    @Override
    public void visit(Manager m) {
        System.out.println("Manager: " + m.getName() + " leading " + m.getDirectReports().size() + " Project Leads");

    }

    @Override
    public void visit(VicePresident vp) {
        System.out.println("VicePresident: " + vp.getName() + " leading " + vp.getDirectReports().size() + " Managers");

    }
}
