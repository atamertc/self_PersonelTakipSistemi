package com.atamert.soru1;

import com.atamert.soru1.personelTipleri.GenelMudur;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class RaporlamaManager {
    static Scanner scanner = new Scanner(System.in);

    public static void departmanPersonelListesi() {
        System.out.println("Personel listesini gormek istediginiz departmani secin");
        System.out.println("1- Teknik Hizmetler Departmani");
        System.out.println("2- Insan Kaynaklari Departmani");
        System.out.println("3- Uretim Departmani");
        System.out.println("4- Satin Alma Departmani");
        System.out.println("5- Mali Isler Departmani");
        int depSecim = Integer.parseInt(scanner.nextLine());
        switch (depSecim) {
            case 1 -> {
                System.out.println("Teknik Hizmetler Departmani Personel Listesi: ");
                Database.personelYazdir(Database.teknikHizmetlerDepartmani.getDepartmanPersonelListesi());
            }
            case 2 -> {
                System.out.println("Insan Kaynaklari Departmani Personel Listesi: ");
                Database.personelYazdir(Database.insanKaynaklariDepartmani.getDepartmanPersonelListesi());
            }
            case 3 -> {
                System.out.println("Uretim Departmani Personel Listesi: ");
                Database.personelYazdir(Database.uretimDepartmani.getDepartmanPersonelListesi());
            }
            case 4 -> {
                System.out.println("Satin Alma Departmani Personel Listesi: ");
                Database.personelYazdir(Database.satinAlmaDepartmani.getDepartmanPersonelListesi());
            }
            case 5 -> {
                System.out.println("Mali Isler Departmani Personel Listesi: ");
                Database.personelYazdir(Database.maliIslerDepartmani.getDepartmanPersonelListesi());
            }
        }
    }

    public static void enCokPersonelBulunanDepartman() {
        Database.departmanListesiYarat();
        Optional<Departman> enCokPersonelliDepartman = Database.departmanListesi.stream()
                .max(Comparator.comparingInt(x -> x.getDepartmanPersonelListesi().size()));
        System.out.print("En cok personel bulunan departman: ");
        System.out.println(enCokPersonelliDepartman.get().getDepartmanAdi());
    }

    public static void departmanlaraGoreMaasOrtalamalari() {
        Database.departmanListesiYarat();
        Map<String, Double> departmanMaasOrtalamalari = new HashMap<>();
        for (Departman departman : Database.departmanListesi) {
            String departmanAdi = departman.getDepartmanAdi();
            List<Personel> personelListesi = departman.getDepartmanPersonelListesi();

            double maasToplami = personelListesi.stream().mapToDouble(Personel::getMaas).sum();
            double maasOrtalamasi = maasToplami / personelListesi.size();
            departmanMaasOrtalamalari.put(departmanAdi, maasOrtalamasi);
        }
        System.out.println("Departmanlara Gore Maas Ortalamalari: ");
        for (Map.Entry<String, Double> entry : departmanMaasOrtalamalari.entrySet()) {
            String departmanAdi = entry.getKey();
            double maasOrtalamasi = entry.getValue();
            System.out.printf("\nDEPARTMAN: %-28s -> ORTALAMA MAAS:  %-8.2f", departmanAdi, maasOrtalamasi);
        }
    }

    public static void genelMudurlerinSorumluDepartmanlari() {
        for (Personel personel : Database.personelListesi) {
            if (personel instanceof GenelMudur) {
                System.out.println("\n" + personel.getAd() + " " + personel.getSoyad() +
                        " isimli Genel Mudurun sorumlu oldugu departmanlar: ");
                Database.departmanYazdir(((GenelMudur) personel).getSorumluDepartmanlar());
            }
        }
    }

    public static void kayitTarihlerineGoreSiraliPersoneller() {
        List<Personel> siraliPersoneller = Database.personelListesi.stream()
                .sorted(Comparator.comparing(Personel::getKayitTarihi))
                .collect(Collectors.toList());
        Database.personelYazdir(siraliPersoneller);
    }

    public static void ayniGunIseBaslayanPersoneller() {
        Map<LocalDate, List<Personel>> tarihGrupluPersonelListesi =
                Database.personelListesi.stream()
                        .collect(Collectors.groupingBy(Personel::getIseGirisTarihi));
        Database.personelYazdir(tarihGrupluPersonelListesi);
    }

}
