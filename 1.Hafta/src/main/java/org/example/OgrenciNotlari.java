package org.example;

import java.util.Scanner;

public class OgrenciNotlari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int toplamNot = 0;
        int enYuksekNot = Integer.MIN_VALUE;
        int enDusukNot = Integer.MAX_VALUE;
        boolean dusukNotVar = false;
        int dersSayisi = 5;

        for (int i = 1; i <= dersSayisi; i++) {
            System.out.print(i + ". dersin notunu giriniz: ");
            int not = scanner.nextInt();

            if (not < 0 || not > 100) {
                System.out.println("Geçersiz not! 0-100 arasında bir değer giriniz.");
                i--;
                continue;
            }

            toplamNot += not;

            if (not < 30) {
                dusukNotVar = true;
            }

            if (not > enYuksekNot) {
                enYuksekNot = not;
            }
            if (not < enDusukNot) {
                enDusukNot = not;
            }
        }

        double ortalama = (double) toplamNot / dersSayisi;
        System.out.println("===============================");
        System.out.println("Not Ortalamanız: " + ortalama);

        if (ortalama >= 50) {
            System.out.println("Tebrikler, dersten geçtiniz! ");
        } else {
            System.out.println("Üzgünüm, kaldınız. ");
        }

        if (dusukNotVar) {
            System.out.println("️ Düşük not aldığınız dersler var!");
        }

        System.out.println("En Yüksek Not: " + enYuksekNot);
        System.out.println("En Düşük Not: " + enDusukNot);
        System.out.println("Başarılar dileriz! ");
        scanner.close();
    }
}
