package com.atamert.soru1;

import com.atamert.soru1.personelTipleri.GenelMudur;
import com.atamert.soru1.personelTipleri.Mudur;

import java.util.*;

public class Departman {
    private String departmanAdi;
    private Mudur mudur;
    private GenelMudur genelMudur;
    private List<Personel> departmanPersonelListesi = new ArrayList<>();

    public Departman(String departmanAdi) {
        this.departmanAdi = departmanAdi;
    }

    public Departman(String departmanAdi, Mudur mudur) {
        this.departmanAdi = departmanAdi;
        this.mudur = mudur;
    }

    public Departman(String departmanAdi, Mudur mudur, GenelMudur genelMudur) {
        this.departmanAdi = departmanAdi;
        this.mudur = mudur;
        this.genelMudur = genelMudur;
    }

    public String getDepartmanAdi() {
        return departmanAdi;
    }

    public void setDepartmanAdi(String departmanAdi) {
        this.departmanAdi = departmanAdi;
    }

    public List<Personel> getDepartmanPersonelListesi() {
        return departmanPersonelListesi;
    }

    public void setDepartmanPersonelListesi(List<Personel> departmanPersonelListesi) {
        this.departmanPersonelListesi = departmanPersonelListesi;
    }

    public Mudur getMudur() {
        return mudur;
    }

    public void setMudur(Mudur mudur) {
        this.mudur = mudur;
    }

    public GenelMudur getGenelMudur() {
        return genelMudur;
    }

    public void setGenelMudur(GenelMudur genelMudur) {
        this.genelMudur = genelMudur;
    }

    @Override
    public String toString() {
        return "\nDepartman{" +
                "departmanAdi='" + departmanAdi + '\'' +
                ", mudur=" + mudur +
                ", genelMudur=" + genelMudur +
                "}\n";
    }
}

