package com.atamert.soru1.personelTipleri;

import com.atamert.soru1.Departman;
import com.atamert.soru1.Personel;

import java.time.LocalDate;

public class Hizmetli extends Personel {
    private String gorevAlani;

    public Hizmetli(String ad, String soyad, int yas, String gorevAlani) {
        super(ad, soyad, yas);
        super.setUnvan("Hizmetli");
        this.gorevAlani = gorevAlani;
    }

    public Hizmetli(String ad, String soyad, int yas, LocalDate localDate) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("Hizmetli");
    }

    public Hizmetli(String ad, String soyad, int yas, String gorevAlani, LocalDate localDate) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("Hizmetli");
        this.gorevAlani = gorevAlani;
    }

    public Hizmetli(String ad, String soyad, int yas, double maas, String gorevAlani, LocalDate localDate) {
        super(ad, soyad, yas, maas, localDate);
        super.setUnvan("Hizmetli");
        this.gorevAlani = gorevAlani;
    }


    public String getGorevAlani() {
        return gorevAlani;
    }

    public void setGorevAlani(String gorevAlani) {
        this.gorevAlani = gorevAlani;
    }
}

