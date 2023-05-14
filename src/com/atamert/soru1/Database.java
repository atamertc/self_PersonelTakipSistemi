package com.atamert.soru1;

import com.atamert.soru1.personelTipleri.*;

import java.time.LocalDate;
import java.util.*;

public class Database {
    static Scanner scanner = new Scanner(System.in);
    public static List<Personel> personelListesi = new ArrayList<>();
    public static List<Departman> departmanListesi = new ArrayList<>();
    public static Departman teknikHizmetlerDepartmani = new Departman("Teknik Hizmetler Departmani");
    public static Departman insanKaynaklariDepartmani = new Departman("Insan Kaynaklari Departmani");
    public static Departman uretimDepartmani = new Departman("Uretim Departmani");
    public static Departman satinAlmaDepartmani = new Departman("Satin Alma Departmani");
    public static Departman maliIslerDepartmani = new Departman("Mali Isler Departmani");

    public static void departmanListesiYarat() {
        if (departmanListesi.size() < 5) {
            departmanListesi.add(insanKaynaklariDepartmani);
            departmanListesi.add(uretimDepartmani);
            departmanListesi.add(teknikHizmetlerDepartmani);
            departmanListesi.add(maliIslerDepartmani);
            departmanListesi.add(satinAlmaDepartmani);
        }
    }

    public static void personelEkle(Personel personel, Departman departman) {
        personelListesi.add(personel);
        departman.getDepartmanPersonelListesi().add(personel);
    }

    public static void personelEkle(Personel personel) {
        personelListesi.add(personel);
    }

    public static void remove() {
        personelYazdir();
        System.out.print("\nSilmek istediginiz personelin ID giriniz: ");
        System.out.println();
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < personelListesi.size(); i++) {
            if (personelListesi.get(i).getId() == id) {
                if (personelListesi.get(i) instanceof Mudur) {
                    ((Mudur) personelListesi.get(i)).getSorumluDepartman().setMudur(null);
                }
                if (personelListesi.get(i) instanceof GenelMudur) {
                    for (Departman departman : ((GenelMudur) personelListesi.get(i)).getSorumluDepartmanlar()) {
                        departman.setGenelMudur(null);
                    }
                }
                System.out.println(personelListesi.get(i).getAd() + " " + personelListesi.get(i).getSoyad() + " isimli personel kayitlardan basariyla silindi.");
                Database.departmanListesiYarat();
                for (Departman departman : departmanListesi) {
                    departman.getDepartmanPersonelListesi().remove(personelListesi.get(i));
                }
                personelListesi.remove(personelListesi.get(i));
                i--;
            }
        }
    }

    public static void save() {
        Personel personel = null;
        System.out.println("Adını giriniz: ");
        String ad = scanner.nextLine();
        System.out.println("Soyadını giriniz: ");
        String soyad = scanner.nextLine();
        System.out.println("Yasini giriniz: ");
        int yas = Integer.parseInt(scanner.nextLine());
        System.out.println("Personel tipini seçiniz");
        System.out.println("1- Buro Personeli");
        System.out.println("2- Genel Mudur");
        System.out.println("3- Hizmetli");
        System.out.println("4- Insan Kaynaklari");
        System.out.println("5- Mudur");
        System.out.println("6- Muhasebe");
        System.out.println("7- Teknik Personel");
        int tipSecimi = Integer.parseInt(scanner.nextLine());
        switch (tipSecimi) {
            case 1 -> {
                System.out.println("Buro Personeli buro numarasini giriniz: ");
                String buroNo = scanner.nextLine();
                System.out.println("Departman secimi yapiniz: ");
                System.out.println("1- Teknik Hizmetler Departmani");
                System.out.println("2- Insan Kaynaklari Departmani");
                System.out.println("3- Uretim Departmani");
                System.out.println("4- Satin Alma Departmani");
                System.out.println("5- Mali Isler Departmani");
                int depSecim = Integer.parseInt(scanner.nextLine());
                switch (depSecim) {
                    case 1 -> {
                        personel = new BuroPersoneli(ad, soyad, yas, buroNo);
                        personelEkle(personel, teknikHizmetlerDepartmani);
                    }
                    case 2 -> {
                        personel = new BuroPersoneli(ad, soyad, yas, buroNo);
                        personelEkle(personel, insanKaynaklariDepartmani);
                    }
                    case 3 -> {
                        personel = new BuroPersoneli(ad, soyad, yas, buroNo);
                        personelEkle(personel, uretimDepartmani);
                    }
                    case 4 -> {
                        personel = new BuroPersoneli(ad, soyad, yas, buroNo);
                        personelEkle(personel, satinAlmaDepartmani);
                    }
                    case 5 -> {
                        personel = new BuroPersoneli(ad, soyad, yas, buroNo);
                        personelEkle(personel, maliIslerDepartmani);
                    }
                }
            }
            case 2 -> {
                personel = new GenelMudur(ad, soyad, yas);
                personelEkle(personel);
            }
            case 3 -> {
                System.out.println("Hizmetli gorev alanini giriniz: ");
                String gorevAlani = scanner.nextLine();
                System.out.println("Departman secimi yapiniz: ");
                System.out.println("1- Teknik Hizmetler Departmani");
                System.out.println("2- Insan Kaynaklari Departmani");
                System.out.println("3- Uretim Departmani");
                System.out.println("4- Satin Alma Departmani");
                System.out.println("5- Mali Isler Departmani");
                int depSecim = Integer.parseInt(scanner.nextLine());
                switch (depSecim) {
                    case 1 -> {
                        personel = new Hizmetli(ad, soyad, yas, gorevAlani);
                        personelEkle(personel, teknikHizmetlerDepartmani);
                    }
                    case 2 -> {
                        personel = new Hizmetli(ad, soyad, yas, gorevAlani);
                        personelEkle(personel, insanKaynaklariDepartmani);
                    }
                    case 3 -> {
                        personel = new Hizmetli(ad, soyad, yas, gorevAlani);
                        personelEkle(personel, uretimDepartmani);
                    }
                    case 4 -> {
                        personel = new Hizmetli(ad, soyad, yas, gorevAlani);
                        personelEkle(personel, satinAlmaDepartmani);
                    }
                    case 5 -> {
                        personel = new Hizmetli(ad, soyad, yas, gorevAlani);
                        personelEkle(personel, maliIslerDepartmani);
                    }
                }
            }
            case 4 -> {
                System.out.println("Insan Kaynaklari birimini giriniz: ");
                String birim = scanner.nextLine();
                System.out.println("Departman secimi yapiniz: ");
                System.out.println("1- Teknik Hizmetler Departmani");
                System.out.println("2- Insan Kaynaklari Departmani");
                System.out.println("3- Uretim Departmani");
                System.out.println("4- Satin Alma Departmani");
                System.out.println("5- Mali Isler Departmani");
                int depSecim = Integer.parseInt(scanner.nextLine());
                switch (depSecim) {
                    case 1 -> {
                        personel = new InsanKaynaklariPersoneli(ad, soyad, yas, birim);
                        personelEkle(personel, teknikHizmetlerDepartmani);
                    }
                    case 2 -> {
                        personel = new InsanKaynaklariPersoneli(ad, soyad, yas, birim);
                        personelEkle(personel, insanKaynaklariDepartmani);
                    }
                    case 3 -> {
                        personel = new InsanKaynaklariPersoneli(ad, soyad, yas, birim);
                        personelEkle(personel, uretimDepartmani);
                    }
                    case 4 -> {
                        personel = new InsanKaynaklariPersoneli(ad, soyad, yas, birim);
                        personelEkle(personel, satinAlmaDepartmani);
                    }
                    case 5 -> {
                        personel = new InsanKaynaklariPersoneli(ad, soyad, yas, birim);
                        personelEkle(personel, maliIslerDepartmani);
                    }
                }
            }
            case 5 -> {
                System.out.println("Mudur sicil no giriniz: ");
                String sicilNo = scanner.nextLine();
                personel = new Mudur(ad, soyad, yas, sicilNo);
                personelEkle(personel);
            }
            case 6 -> {
                System.out.println("Muhasebe Personeli uzmanlik alanini giriniz: ");
                String muhasebeUzmanligi = scanner.nextLine();
                System.out.println("Departman secimi yapiniz: ");
                System.out.println("1- Teknik Hizmetler Departmani");
                System.out.println("2- Insan Kaynaklari Departmani");
                System.out.println("3- Uretim Departmani");
                System.out.println("4- Satin Alma Departmani");
                System.out.println("5- Mali Isler Departmani");
                int depSecim = Integer.parseInt(scanner.nextLine());
                switch (depSecim) {
                    case 1 -> {
                        personel = new MuhasebePersoneli(ad, soyad, yas, muhasebeUzmanligi);
                        personelEkle(personel, teknikHizmetlerDepartmani);
                    }
                    case 2 -> {
                        personel = new MuhasebePersoneli(ad, soyad, yas, muhasebeUzmanligi);
                        personelEkle(personel, insanKaynaklariDepartmani);
                    }
                    case 3 -> {
                        personel = new MuhasebePersoneli(ad, soyad, yas, muhasebeUzmanligi);
                        personelEkle(personel, uretimDepartmani);
                    }
                    case 4 -> {
                        personel = new MuhasebePersoneli(ad, soyad, yas, muhasebeUzmanligi);
                        personelEkle(personel, satinAlmaDepartmani);
                    }
                    case 5 -> {
                        personel = new MuhasebePersoneli(ad, soyad, yas, muhasebeUzmanligi);
                        personelEkle(personel, maliIslerDepartmani);
                    }
                }
            }
            case 7 -> {
                System.out.println("Teknik Personeli ustalik belgesini giriniz: ");
                String ustalikBelgesi = scanner.nextLine();
                System.out.println("Departman secimi yapiniz: ");
                System.out.println("1- Teknik Hizmetler Departmani");
                System.out.println("2- Insan Kaynaklari Departmani");
                System.out.println("3- Uretim Departmani");
                System.out.println("4- Satin Alma Departmani");
                System.out.println("5- Mali Isler Departmani");
                int depSecim = Integer.parseInt(scanner.nextLine());
                switch (depSecim) {
                    case 1 -> {
                        personel = new TeknikPersonel(ad, soyad, yas, ustalikBelgesi);
                        personelEkle(personel, teknikHizmetlerDepartmani);
                    }
                    case 2 -> {
                        personel = new TeknikPersonel(ad, soyad, yas, ustalikBelgesi);
                        personelEkle(personel, insanKaynaklariDepartmani);
                    }
                    case 3 -> {
                        personel = new TeknikPersonel(ad, soyad, yas, ustalikBelgesi);
                        personelEkle(personel, uretimDepartmani);
                    }
                    case 4 -> {
                        personel = new TeknikPersonel(ad, soyad, yas, ustalikBelgesi);
                        personelEkle(personel, satinAlmaDepartmani);
                    }
                    case 5 -> {
                        personel = new TeknikPersonel(ad, soyad, yas, ustalikBelgesi);
                        personelEkle(personel, maliIslerDepartmani);
                    }
                }
            }
            default -> System.out.println("Hatali secim");
        }

    }

    public static void find() {
        System.out.println("Personeli Nasil Gormek Istersiniz: ");
        System.out.println("1- ID ILE BUL VE GETIR");
        System.out.println("2- TUM PERSONELLERI LISTELE");
        int ikiSecenek = Integer.parseInt(scanner.nextLine());
        if (ikiSecenek == 1) {
            System.out.println("Aradiginiz personelin ID giriniz");
            int id = Integer.parseInt(scanner.nextLine());
            int kontrol = 0;
            for (Personel personel : personelListesi) {
                if (personel.getId() == id) {
                    System.out.println("Aradiginiz personel bulundu: ");
                    personelYazdir(personel);
                    kontrol++;
                }
            }
            if (kontrol == 0) {
                System.out.println("Aradiginiz personel kayitlarda yok");
            }
        } else if (ikiSecenek == 2) {
            Database.personelYazdir();
        } else {
            System.out.println("Hatali Secim!");
        }
    }

    public static void personelYazdir() {
        String format = "| %-3s | %-18s | %-12s | %-12s |%-4s | %-8s | %-16s | %-14s |\n";
        System.out.println("_______________________________________________________________________________________________________________");
        System.out.format(format, "ID", "UNVAN", "AD", "SOYAD", "YAS", "MAAS", "ISE GIRIS TARIHI", "KAYIT TARIHI");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        for (Personel p : personelListesi) {
            System.out.format(format, p.getId(), p.getUnvan(), p.getAd(), p.getSoyad(), p.getYas(), p.getMaas(), p.getIseGirisTarihi(), p.getKayitTarihi());
        }
    }

    public static void personelYazdir(Personel p) {
        String format = "| %-3s | %-18s | %-12s | %-12s |%-4s | %-8s | %-16s | %-14s |\n";
        System.out.println("_______________________________________________________________________________________________________________");
        System.out.format(format, "ID", "UNVAN", "AD", "SOYAD", "YAS", "MAAS", "ISE GIRIS TARIHI", "KAYIT TARIHI");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        System.out.format(format, p.getId(), p.getUnvan(), p.getAd(), p.getSoyad(), p.getYas(), p.getMaas(), p.getIseGirisTarihi(), p.getKayitTarihi());
    }

    public static void personelYazdir(List<Personel> personelListesi) {
        String format = "| %-3s | %-18s | %-12s | %-12s |%-4s | %-8s | %-16s | %-14s |\n";
        System.out.println("_______________________________________________________________________________________________________________");
        System.out.format(format, "ID", "UNVAN", "AD", "SOYAD", "YAS", "MAAS", "ISE GIRIS TARIHI", "KAYIT TARIHI");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        for (Personel p : personelListesi) {
            System.out.format(format, p.getId(), p.getUnvan(), p.getAd(), p.getSoyad(), p.getYas(), p.getMaas(), p.getIseGirisTarihi(), p.getKayitTarihi());
        }
    }

    public static void personelYazdir(Map<LocalDate, List<Personel>> tarihGrupluMap) {
        String format = "| %-3s | %-18s | %-12s | %-12s |%-4s | %-8s | %-16s | %-14s |\n";
        for (Map.Entry<LocalDate, List<Personel>> entry : tarihGrupluMap.entrySet()) {
            System.out.println("\nTARIH GRUBU: " + entry.getKey());
            System.out.println("_______________________________________________________________________________________________________________");
            System.out.format(format, "ID", "UNVAN", "AD", "SOYAD", "YAS", "MAAS", "ISE GIRIS TARIHI", "KAYIT TARIHI");
            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
            for (Personel p : entry.getValue()) {
                System.out.format(format, p.getId(), p.getUnvan(), p.getAd(), p.getSoyad(), p.getYas(), p.getMaas(), p.getIseGirisTarihi(), p.getKayitTarihi());
            }
        }
    }

    public static void departmanYazdir(Set<Departman> sorumluDepartmanlar) {
        String format = "| %-30s | %-24s | %-24s |\n";
        System.out.println("________________________________________________________________________________________");
        System.out.format(format, "DEPARTMAN ADI", "DEPARTMAN GENEL MUDURU", "DEPARTMAN MUDURU");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        for (Departman d : sorumluDepartmanlar) {
            System.out.format(format, d.getDepartmanAdi(), d.getGenelMudur().getAd() + " " + d.getGenelMudur().getSoyad(), d.getMudur().getAd() + " " + d.getMudur().getSoyad());
        }
    }

    public static void departmanYazdir(List<Departman> departmanListesi) {
        String format = "| %-30s | %-24s | %-24s |\n";
        System.out.println("________________________________________________________________________________________");
        System.out.format(format, "DEPARTMAN ADI", "DEPARTMAN GENEL MUDURU", "DEPARTMAN MUDURU");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        for (Departman d : departmanListesi) {
            System.out.format(format, d.getDepartmanAdi(), d.getGenelMudur(), d.getMudur());
        }
    }

    public static void maasYazdir() {
        String format = "| %-3s | %-18s | %-12s | %-12s |%-4s | %-8s |\n";
        System.out.println("___________________________________________________________________________");
        System.out.format(format, "ID", "UNVAN", "AD", "SOYAD", "YAS", "MAAS");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        personelListesi.stream()
                .sorted(Comparator.comparing(Personel::getMaas).reversed())
                .forEach(p -> {
                    System.out.format(format, p.getId(), p.getUnvan(), p.getAd(), p.getSoyad(), p.getYas(), p.getMaas());
                });
    }


}