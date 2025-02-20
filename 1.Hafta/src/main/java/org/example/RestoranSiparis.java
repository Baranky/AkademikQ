package org.example;

import java.util.Scanner;

public class RestoranSiparis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int toplamFiyat = 0;
        int secim;

        System.out.println("=== Restoran Menü ===");
        System.out.println("1 - Pizza (120 TL)");
        System.out.println("2 - Burger (90 TL)");
        System.out.println("3 - Makarna (75 TL)");
        System.out.println("4 - Salata (50 TL)");
        System.out.println("5 - Çıkış ve Hesap Ödeme");

        do {
            System.out.print("Lütfen bir seçim yapınız: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Pizza seçtiniz! ");
                    toplamFiyat += 120;
                    break;
                case 2:
                    System.out.println("Burger seçtiniz");
                    toplamFiyat += 90;
                    break;
                case 3:
                    System.out.println("Makarna seçtiniz");
                    toplamFiyat += 75;
                    break;
                case 4:
                    System.out.println("Salata seçtiniz");
                    toplamFiyat += 50;
                    break;
                case 5:
                    System.out.println("Sipariş tamamlandı. Toplam hesap: " + toplamFiyat + " TL ");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen 1-5 arasında bir değer giriniz.");
            }
        } while (secim != 5);

        System.out.println("Afiyet olsun");
        scanner.close();
    }
}

