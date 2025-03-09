package org.example.bonusHesaplama;

import org.example.bonusHesaplama.Employee;

public class Manager  extends Employee {
    private int teamSize;


    public Manager(int id, String name, int salary, String department, int teamSize) {
        super(id, name, salary, department);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
    @Override
    public int calculateBonus() {
        return (int) (getSalary()*0.2);
    }
}
