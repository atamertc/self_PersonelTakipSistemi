package com.atamert.soru1.personelTipleri;

import com.atamert.soru1.Departman;
import com.atamert.soru1.Personel;

import java.time.LocalDate;

public class InsanKaynaklariPersoneli extends Personel {
    private String birim;


    public InsanKaynaklariPersoneli(String ad, String soyad, int yas, String birim) {
        super(ad, soyad, yas);
        super.setUnvan("IK Personeli");
        this.birim = birim;
    }

    public InsanKaynaklariPersoneli(String ad, String soyad, int yas, LocalDate localDate) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("IK Personeli");
    }

    public InsanKaynaklariPersoneli(String ad, String soyad, int yas, String birim, LocalDate localDate) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("IK Personeli");
        this.birim = birim;
    }

    public InsanKaynaklariPersoneli(String ad, String soyad, int yas, double maas, String birim, LocalDate localDate) {
        super(ad, soyad, yas, maas, localDate);
        super.setUnvan("IK Personeli");
        this.birim = birim;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }
}

