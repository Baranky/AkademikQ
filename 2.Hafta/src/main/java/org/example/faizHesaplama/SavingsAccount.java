package org.example.faizHesaplama;

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * 0.05; // %5 faiz hesaplanıyor
        System.out.println(getAccountHolder() + " için hesaplanan faiz: " + interest + " TL");
    }
}