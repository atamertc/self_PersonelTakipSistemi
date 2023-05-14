package com.atamert.soru1.personelTipleri;

import com.atamert.soru1.Database;
import com.atamert.soru1.Departman;
import com.atamert.soru1.Personel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GenelMudur extends Personel {
    private Set<Departman> sorumluDepartmanlar = new HashSet<>();

    public GenelMudur(String ad, String soyad, int yas) {
        super(ad, soyad, yas);
        super.setUnvan("Genel Mudur");
        this.sorumluDepartmanlar = genelMudurSorumluDepartmanAta();
    }

    public GenelMudur(String ad, String soyad, int yas, Set<Departman> sorumluDepartmanlar) {
        super(ad, soyad, yas);
        super.setUnvan("Genel Mudur");
        this.sorumluDepartmanlar = sorumluDepartmanlar;
        departmanlaraGenelMudurSetle();
    }

    public GenelMudur(String ad, String soyad, int yas, Set<Departman> sorumluDepartmanlar, LocalDate localDate) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("Genel Mudur");
        this.sorumluDepartmanlar = sorumluDepartmanlar;
        departmanlaraGenelMudurSetle();
    }

    public GenelMudur(String ad, String soyad, int yas, double maas, Set<Departman> sorumluDepartmanlar, LocalDate localDate) {
        super(ad, soyad, yas, maas, localDate);
        super.setUnvan("Genel Mudur");
        this.sorumluDepartmanlar = sorumluDepartmanlar;
        departmanlaraGenelMudurSetle();
    }

    private void departmanlaraGenelMudurSetle() {
        for (Departman departman : sorumluDepartmanlar) {
            departman.setGenelMudur(this);
        }
    }

    private Set<Departman> genelMudurSorumluDepartmanAta() {
        Scanner scanner = new Scanner(System.in);
        int secim = 0;
        do {
            System.out.println("\nGenel Mudure atanacak departmanlari seciniz");
            System.out.println("1- Teknik Hizmetler Departmani");
            System.out.println("2- Insan Kaynaklari Departmani");
            System.out.println("3- Uretim Departmani");
            System.out.println("4- Satin Alma Departmani");
            System.out.println("5- Mali Isler Departmani");
            System.out.println("0- Bitti.");
            secim = Integer.parseInt(scanner.nextLine());
            switch (secim) {
                case 1 -> {
                    if (Database.teknikHizmetlerDepartmani.getGenelMudur() == null) {
                        sorumluDepartmanlar.add(Database.teknikHizmetlerDepartmani);
                        System.out.println(this.getAd() + " " + this.getSoyad() +
                                " isimli Genel Mudure -> Teknik Hizmetler Departmani atandi");
                        Database.teknikHizmetlerDepartmani.setGenelMudur(this);
                    } else {
                        System.out.println(Database.teknikHizmetlerDepartmani.getDepartmanAdi() +
                                " zaten bir Genel Mudure sahip!");
                    }
                }
                case 2 -> {
                    if (Database.insanKaynaklariDepartmani.getGenelMudur() == null) {
                        sorumluDepartmanlar.add(Database.insanKaynaklariDepartmani);
                        System.out.println(this.getAd() + " " + this.getSoyad() +
                                " isimli Genel Mudure -> Insan Kaynaklari Departmani atandi");
                        Database.insanKaynaklariDepartmani.setGenelMudur(this);
                    } else {
                        System.out.println(Database.insanKaynaklariDepartmani.getDepartmanAdi() +
                                " zaten bir Genel Mudure sahip!");
                    }
                }
                case 3 -> {
                    if (Database.uretimDepartmani.getGenelMudur() == null) {
                        sorumluDepartmanlar.add(Database.uretimDepartmani);
                        System.out.println(this.getAd() + " " + this.getSoyad() +
                                " isimli Genel Mudure -> Uretim Departmani atandi");
                        Database.uretimDepartmani.setGenelMudur(this);
                    } else {
                        System.out.println(Database.uretimDepartmani.getDepartmanAdi() +
                                " zaten bir Genel Mudure sahip!");
                    }
                }
                case 4 -> {
                    if (Database.satinAlmaDepartmani.getGenelMudur() == null) {
                        sorumluDepartmanlar.add(Database.satinAlmaDepartmani);
                        System.out.println(this.getAd() + " " + this.getSoyad() +
                                " isimli Genel Mudure -> Satin Alma Departmani atandi");
                        Database.satinAlmaDepartmani.setGenelMudur(this);
                    } else {
                        System.out.println(Database.satinAlmaDepartmani.getDepartmanAdi() +
                                " zaten bir Genel Mudure sahip!");
                    }
                }
                case 5 -> {
                    if (Database.maliIslerDepartmani.getGenelMudur() == null) {
                        sorumluDepartmanlar.add(Database.maliIslerDepartmani);
                        System.out.println(this.getAd() + " " + this.getSoyad() +
                                " isimli Genel Mudure -> Mali Isler Departmani atandi");
                        Database.maliIslerDepartmani.setGenelMudur(this);
                    } else {
                        System.out.println(Database.maliIslerDepartmani.getDepartmanAdi() +
                                " zaten bir Genel Mudure sahip!");
                    }
                }
            }
        } while (secim != 0);
        return sorumluDepartmanlar;
    }

    public Set<Departman> getSorumluDepartmanlar() {
        return sorumluDepartmanlar;
    }

    public void setSorumluDepartmanlar(Set<Departman> sorumluDepartmanlar) {
        this.sorumluDepartmanlar = sorumluDepartmanlar;
    }

}

