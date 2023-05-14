package com.atamert.soru1.personelTipleri;

import com.atamert.soru1.Departman;
import com.atamert.soru1.Personel;

import java.time.LocalDate;

public class TeknikPersonel extends Personel {
    private String ustalikBelgesi;


    public TeknikPersonel(String ad, String soyad, int yas, String ustalikBelgesi) {
        super(ad, soyad, yas);
        super.setUnvan("Teknik Personel");
        this.ustalikBelgesi = ustalikBelgesi;
    }

    public TeknikPersonel(String ad, String soyad, int yas, LocalDate localDate) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("Teknik Personel");
    }

    public TeknikPersonel(String ad, String soyad, int yas, String ustalikBelgesi, LocalDate localDate) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("Teknik Personel");
        this.ustalikBelgesi = ustalikBelgesi;
    }

    public TeknikPersonel(String ad, String soyad, int yas, double maas, String ustalikBelgesi, LocalDate localDate) {
        super(ad, soyad, yas, maas, localDate);
        super.setUnvan("Teknik Personel");
        this.ustalikBelgesi = ustalikBelgesi;
    }

    public String getUstalikBelgesi() {
        return ustalikBelgesi;
    }

    public void setUstalikBelgesi(String ustalikBelgesi) {
        this.ustalikBelgesi = ustalikBelgesi;
    }
}

