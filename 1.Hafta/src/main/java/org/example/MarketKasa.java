package org.example;

import java.util.Scanner;

public class MarketKasa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double toplamTutar = 0;
        boolean indirimUygulandi = false;

        System.out.println("=== Market Kasasına Hoş Geldiniz! ===");
        System.out.println("Ürünler:");
        System.out.println("1 - Ekmek (10 TL)");
        System.out.println("2 - Süt (25 TL)");
        System.out.println("3 - Yumurta (30 TL)");
        System.out.println("0 - Alışverişi Bitir");

        while (true) {
            System.out.print("Lütfen bir ürün seçin (Çıkış için 0): ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    toplamTutar += 10;
                    System.out.println("Ekmek sepete eklendi. Toplam: " + toplamTutar + " TL");
                    break;
                case 2:
                    toplamTutar += 25;
                    System.out.println("Süt sepete eklendi. Toplam: " + toplamTutar + " TL");
                    break;
                case 3:
                    toplamTutar += 30;
                    System.out.println("Yumurta sepete eklendi. Toplam: " + toplamTutar + " TL");
                    break;
                case 0:
                    System.out.println("Alışveriş tamamlandı.");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
                    continue;
            }

            if (secim == 0) {
                break;
            }
        }

        // Kullanıcıya indirim kuponu sorma
        System.out.print("İndirim kuponunuz var mı? (Evet için '1', Hayır için '0' girin): ");
        int kupon = scanner.nextInt();

        if (kupon == 1) {
            toplamTutar *= 0.9; // %10 indirim uygulanıyor
            indirimUygulandi = true;
        }

        // Ödeme bilgisi
        System.out.println("===============================");
        System.out.println("Toplam Ödenecek Tutar: " + toplamTutar + " TL");
        if (indirimUygulandi) {
            System.out.println("İndirim uygulandı! Yeni fiyat hesaplandı.");
        }
        System.out.println("Teşekkür ederiz, iyi günler!");
        scanner.close();
    }
}
