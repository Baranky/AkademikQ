package org.example;

import java.util.Scanner;

public class TrafikCezasi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int HIZ_SINIRI = 90;

        System.out.print("Lütfen hızınızı giriniz (km/s): ");
        int hiz = scanner.nextInt();
        int ceza = 0;
        boolean ehliyeteElKonuldu = false;

        if (hiz > HIZ_SINIRI) {
            int fark = hiz - HIZ_SINIRI;

            switch (fark / 20) { // Hız aşımına göre kategori belirleme
                case 0:
                    ceza = 1000;
                    System.out.println("Hız sınırını aştınız! Ceza: " + ceza + " TL");
                    break;
                case 1:
                    ceza = 2000;
                    System.out.println("Hız sınırını fazlasıyla aştınız! Ceza: " + ceza + " TL");
                    break;
                default:
                    ehliyeteElKonuldu = true;
                    System.out.println("Hız sınırını ciddi şekilde aştınız! Ehliyetinize el konuldu.");
                    break;
            }
        } else {
            System.out.println("Tebrikler! Hız sınırına uygun sürüyorsunuz.");
        }

        System.out.println("===============================");
        if (!ehliyeteElKonuldu && ceza > 0) {
            System.out.println("Ödenecek Ceza: " + ceza + " TL");
        }
        System.out.println("Güvenli sürüşler dileriz!");
        scanner.close();
    }
}
