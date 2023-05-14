package com.atamert.soru1;

import java.util.Scanner;

public class MuhasebeManager {
    static Scanner scanner = new Scanner(System.in);

    public static void maasAta() {
        int kontrol = 0;
        Database.maasYazdir();
        for (Personel personel : Database.personelListesi) {
            if (personel.getMaas() == 0) {
                System.out.println("Maasi atanacak personelin ismi: " + personel.getAd() + " " + personel.getSoyad());
                System.out.println("Atanacak maasi giriniz: ");
                double maas = Double.parseDouble(scanner.nextLine());
                personel.setMaas(maas);
                System.out.println("Maas atamasi yapilmistir.");
                kontrol++;
            }
        }
        if (kontrol == 0) {
            System.out.println("\n- Maasi atanmamis personel bulunmamaktadir. -");
        }
    }

    public static void maasDuzenle() {
        Database.maasYazdir();
        System.out.println("\nMaasini degistirmek istediginiz personelin ID giriniz: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Personel p : Database.personelListesi) {
            if (p.getId() == id) {
                System.out.println("PERSONEL: " + p.getAd() + " " + p.getSoyad() +
                        " -> ESKI MAAS: " + p.getMaas());
                System.out.print("YENI MAAS: ");
                double yeniMaas = Double.parseDouble(scanner.nextLine());
                p.setMaas(yeniMaas);
                System.out.println("\nMaas guncellemesi basarili...");
            }
        }
    }

    public static void odemeListele() {
        Database.maasYazdir();
        double toplamMaas = Database.personelListesi.stream()
                .mapToDouble(Personel::getMaas)
                .sum();
        System.out.println("___________________________________________________________________________");
        System.out.println("SIRKET AYLIK MAAS ODEMELERI TOPLAMI:                           | " + toplamMaas + " |");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        System.out.println("(EK BILGI: Tablodaki personeller maaslarina gore siralanmistir.)");
    }


}
