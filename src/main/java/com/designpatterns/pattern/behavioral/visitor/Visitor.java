package com.designpatterns.pattern.behavioral.visitor;

public interface Visitor {
    void visit(Programmer p);
    void visit(ProjectLead pl);
    void visit(Manager m);
    void visit(VicePresident vp);


}
