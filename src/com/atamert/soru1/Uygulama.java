package com.atamert.soru1;

import com.atamert.soru1.personelTipleri.GenelMudur;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Uygulama {
    static Scanner scanner = new Scanner(System.in);

    public static void personelTakipSistemi() {

        int secim1 = 0;
        do {
            UI.anaMenu();
            secim1 = Integer.parseInt(scanner.nextLine());
            switch (secim1) {
                case 1:
                    personelIslemleri();
                    break;
                case 2:
                    muhasebeIslemleri();
                    break;
                case 3:
                    raporlamalar();
                    break;
                case 0:
                    System.out.println("Cikis yapildi");
                    break;
                default:
                    System.out.println("Hatali secim!");
                    break;
            }
        } while (secim1 != 0);
    }

    public static void personelIslemleri() {
        int secim2 = 0;
        do {
            UI.personelMenu();
            secim2 = Integer.parseInt(scanner.nextLine());
            switch (secim2) {
                case 1:
                    Database.save();
                    break;
                case 2:
                    Database.find();
                    break;
                case 3:
                    Database.remove();
                    break;
                case 4:
                    System.err.println("Departman ekleme islemi 1.59 surumu ile birlikte gelecektir. " +
                            "\nAnlayisiniz icin tesekkur ederiz...");
                    break;
                case 5:
                    Database.departmanListesiYarat();
                    System.out.println("DEPARTMAN LISTESI ASAGIDADIR: ");
                    Database.departmanYazdir(Database.departmanListesi);
                    break;
                case 0:
                    System.out.println("Onceki menuye donuldu");
                    break;
                default:
                    System.out.println("Hatali secim!");
                    break;
            }
        } while (secim2 != 0);
    }

    private static void muhasebeIslemleri() {
        int secim3 = 0;
        do {
            UI.muhasebeMenu();
            secim3 = Integer.parseInt(scanner.nextLine());
            switch (secim3) {
                case 1:
                    MuhasebeManager.maasAta();
                    break;
                case 2:
                    MuhasebeManager.maasDuzenle();
                    break;
                case 3:
                    MuhasebeManager.odemeListele();
                    break;
                case 0:
                    System.out.println("Onceki menuye donuldu");
                    break;
                default:
                    System.out.println("Hatali secim!");
                    break;
            }
        } while (secim3 != 0);
    }

    private static void raporlamalar() {
        int secim4 = 0;
        do {
            UI.raporlamaMenu();
            secim4 = Integer.parseInt(scanner.nextLine());
            switch (secim4) {
                case 1:
                    RaporlamaManager.departmanPersonelListesi();
                    break;
                case 2:
                    RaporlamaManager.enCokPersonelBulunanDepartman();
                    break;
                case 3:
                    RaporlamaManager.departmanlaraGoreMaasOrtalamalari();
                    break;
                case 4:
                    RaporlamaManager.genelMudurlerinSorumluDepartmanlari();
                    break;
                case 5:
                    RaporlamaManager.kayitTarihlerineGoreSiraliPersoneller();
                    break;
                case 6:
                    RaporlamaManager.ayniGunIseBaslayanPersoneller();
                    break;
                case 0:
                    System.out.println("Onceki menuye donuldu");
                    break;
                default:
                    System.out.println("Hatali secim!");
                    break;
            }
        } while (secim4 != 0);
    }
}
