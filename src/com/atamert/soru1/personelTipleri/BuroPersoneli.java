package com.atamert.soru1.personelTipleri;

import com.atamert.soru1.Departman;
import com.atamert.soru1.Personel;

import java.time.LocalDate;

public class BuroPersoneli extends Personel {
    private String buroNo;


    public BuroPersoneli(String ad, String soyad, int yas, String buroNo) {
        super(ad, soyad, yas);
        super.setUnvan("Buro Personeli");
        this.buroNo = buroNo;
    }

    public BuroPersoneli(String ad, String soyad, int yas, LocalDate localDate) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("Buro Personeli");
    }

    public BuroPersoneli(String ad, String soyad, int yas, String buroNo, LocalDate localDate) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("Buro Personeli");
    }

    public BuroPersoneli(String ad, String soyad, int yas, double maas, String buroNo, LocalDate localDate) {
        super(ad, soyad, yas, maas, localDate);
        super.setUnvan("Buro Personeli");
    }

    public String getBuroNo() {
        return buroNo;
    }

    public void setBuroNo(String buroNo) {
        this.buroNo = buroNo;
    }
}

