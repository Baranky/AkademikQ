package org.example;

import java.util.Scanner;

public class ATMSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int balance = 1000; // Başlangıç bakiyesi
        int attempts = 3; // Maksimum giriş denemesi
        boolean isAuthenticated = true;

        // Menü işlemleri
        while (true) {
            System.out.println("\nATM MENÜSÜ");
            System.out.println("1. Bakiye Görüntüleme");
            System.out.println("2. Para Yatırma");
            System.out.println("3. Para Çekme");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminizi yapın: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Mevcut bakiyeniz: " + balance + " TL");
                    break;

                case 2:
                    System.out.print("Yatırmak istediğiniz miktarı giriniz: ");
                    int deposit = scanner.nextInt();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println(deposit + " TL yatırıldı. Güncel bakiyeniz: " + balance + " TL");
                    } else {
                        System.out.println("Geçersiz miktar!");
                    }
                    break;

                case 3:
                    System.out.print("Çekmek istediğiniz miktarı giriniz: ");
                    int withdraw = scanner.nextInt();
                    if (withdraw > balance) {
                        System.out.println("Yetersiz bakiye! Güncel bakiyeniz: " + balance + " TL");
                    } else if (withdraw > 0) {
                        balance -= withdraw;
                        System.out.println(withdraw + " TL çekildi. Güncel bakiyeniz: " + balance + " TL");
                    } else {
                        System.out.println("Geçersiz miktar!");
                    }
                    break;

                case 4:
                    System.out.println("Çıkış yapılıyor. İyi günler!");
                    return;

                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }
    }
}
