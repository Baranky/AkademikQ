package org.example.bonusHesaplama;

public class Main {
    public static void main(String[] args) {

    Employee employee=new Developer(1,"ali",3000,"Arge","hakkında");
    Employee employee1= new Manager(1,"ahmet",5000,"yonetici",10);
    System.out.println("developer bonus:"+employee.calculateBonus());
    System.out.println("manager bonus:"+employee1.calculateBonus());
    }
}