package com.atamert.soru1.personelTipleri;

import com.atamert.soru1.Departman;
import com.atamert.soru1.Personel;

import java.time.LocalDate;

public class MuhasebePersoneli extends Personel {
    private String muhasebeUzmanligi;


    public MuhasebePersoneli(String ad, String soyad, int yas, String muhasebeUzmanligi) {
        super(ad, soyad, yas);
        super.setUnvan("Muhasebe Personeli");
        this.muhasebeUzmanligi = muhasebeUzmanligi;
    }

    public MuhasebePersoneli(String ad, String soyad, int yas, LocalDate localDate) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("Muhasebe Personeli");
    }

    public MuhasebePersoneli(String ad, String soyad, int yas, String muhasebeUzmanligi, LocalDate localDate) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("Muhasebe Personeli");
        this.muhasebeUzmanligi = muhasebeUzmanligi;
    }

    public MuhasebePersoneli(String ad, String soyad, int yas, double maas, String muhasebeUzmanligi, LocalDate localDate) {
        super(ad, soyad, yas, maas, localDate);
        super.setUnvan("Muhasebe Personeli");
        this.muhasebeUzmanligi = muhasebeUzmanligi;
    }


    public String getMuhasebeUzmanligi() {
        return muhasebeUzmanligi;
    }

    public void setMuhasebeUzmanligi(String muhasebeUzmanligi) {
        this.muhasebeUzmanligi = muhasebeUzmanligi;
    }
}

