package com.atamert.soru1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

public abstract class Personel {
    private int id;
    private String unvan;
    private String ad;
    private String soyad;
    private int yas;
    private double maas;
    private LocalDate iseGirisTarihi;
    private LocalDate kayitTarihi;
    private static int index;

    public Personel(String ad, String soyad, int yas) {
        this.id = idVer();
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.iseGirisTarihi = iseGirisTarihiAta();
        this.kayitTarihi = LocalDate.now();
    }

    public Personel(String ad, String soyad, int yas, LocalDate iseGirisTarihi) {
        this.id = idVer();
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.iseGirisTarihi = iseGirisTarihi;
        this.kayitTarihi = LocalDate.now();
    }

    public Personel(String ad, String soyad, int yas, double maas, LocalDate iseGirisTarihi) {
        this.id = idVer();
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.maas = maas;
        this.iseGirisTarihi = iseGirisTarihi;
        this.kayitTarihi = LocalDate.now();
    }

    public int idVer() {
        index++;
        return index;
    }

    public LocalDate iseGirisTarihiAta() {
        Scanner sc = new Scanner(System.in);
        System.out.println(this.ad + " " + this.soyad + " isimli personel ise giris tarihini gun/ay/yil seklinde giriniz");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String input = sc.nextLine();
        LocalDate iseGirisTarihi = LocalDate.parse(input, formatter);
        return iseGirisTarihi;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }


    public LocalDate getIseGirisTarihi() {
        return iseGirisTarihi;
    }

    public void setIseGirisTarihi(LocalDate iseGirisTarihi) {
        this.iseGirisTarihi = iseGirisTarihi;
    }

    public LocalDate getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(LocalDate kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ad + " " + soyad;
    }


}
