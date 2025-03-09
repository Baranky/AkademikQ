package org.example.faizHesaplama;

public class Main {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("Ali Veli", 10000);
        BankAccount checking = new CheckingAccount("Ayşe Yılmaz", 5000);


        savings.calculateInterest();
        checking.calculateInterest();
    }
}