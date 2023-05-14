package com.atamert.soru1;

import com.atamert.soru1.personelTipleri.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        //***************************** BASLANGIC VERILERI ********************************
        //Ise giris tarihlerini baslangic verileri icin olusturdum
        LocalDate d1 = LocalDate.of(2022, 11, 24);
        LocalDate d2 = LocalDate.of(2022, 11, 24);
        LocalDate d3 = LocalDate.of(2022, 9, 12);
        LocalDate d4 = LocalDate.of(2022, 9, 12);
        LocalDate d5 = LocalDate.of(2022, 9, 12);
        LocalDate d6 = LocalDate.of(2023, 3, 15);
        LocalDate d7 = LocalDate.of(2023, 3, 15);
        LocalDate d8 = LocalDate.of(2023, 3, 15);
        LocalDate d9 = LocalDate.of(2023, 3, 15);
        LocalDate d10 = LocalDate.of(2021, 5, 16);
        LocalDate d11= LocalDate.of(2021, 5, 16);
        LocalDate d12 = LocalDate.of(2021, 5, 16);
        LocalDate d13= LocalDate.of(2020, 1, 29);
        LocalDate d14= LocalDate.of(2019, 12, 25);
        //2 Farkli genel mudure atamak icin sorumlu departmanlar listesi olusturdum
        Set<Departman> sorumluDepartmanlar = new HashSet<>();
        sorumluDepartmanlar.add(Database.insanKaynaklariDepartmani);
        sorumluDepartmanlar.add(Database.maliIslerDepartmani);
        sorumluDepartmanlar.add(Database.uretimDepartmani);
        Set<Departman> sorumluDepartmanlar2 = new HashSet<>();
        sorumluDepartmanlar2.add(Database.satinAlmaDepartmani);
        sorumluDepartmanlar2.add(Database.teknikHizmetlerDepartmani);
        //Mudur ve Genel Mudurlerin sorumlu departmanlari Constructor ile ataniyor
        Personel p1 = new Mudur("Ertem", "Sener", 47,25200, "A312", d1,Database.insanKaynaklariDepartmani);
        Personel p2 = new Mudur("Abdulkerim", "Durmaz", 62,26000, "B412", d2,Database.uretimDepartmani);
        Personel p3 = new Mudur("Ahmet", "Cakar", 60,27500, "C212", d3,Database.teknikHizmetlerDepartmani);
        Personel p4 = new Mudur("Sinan", "Engin", 58,23200, "D612", d4,Database.maliIslerDepartmani);
        Personel p5 = new Mudur("Rasim Ozan", "Kutahyali",42, 22100, "E112", d5,Database.satinAlmaDepartmani);
        Personel p6 = new GenelMudur("Hamdi", "Bey", 56,57800, sorumluDepartmanlar,d6);
        Personel p14 = new GenelMudur("Faruk", "Bey", 64,51800, sorumluDepartmanlar2,d7);
        Personel p7 = new BuroPersoneli("Atamert", "Cakir", 26,10350, "buro1",d8);
        Personel p8 = new Hizmetli("Yaren", "Hanci", 26,8500, "AtamertinKalbi", d9);
        Personel p9 = new MuhasebePersoneli("Zuhal", "Cakir", 60,12250, "IleriMaliye", d10);
        Personel p10 = new TeknikPersonel("Baris", "Demirci", 35,19600, "Java God", d11);
        Personel p11= new InsanKaynaklariPersoneli("Bilge", "Zalim", 26,14500, "Isten Cikarma Birimi", d12);
        Personel p12= new TeknikPersonel("Kobra", "Murat", 48,9600, "Bir Recali Var", d13);
        Personel p13 = new BuroPersoneli("Arif", "Isik", 55,16400, "gora2", d14);
        Database.personelEkle(p1); //Mudur eklerken departman belirtilmez
        Database.personelEkle(p2); //Mudur eklerken departman belirtilmez
        Database.personelEkle(p3); //Mudur eklerken departman belirtilmez
        Database.personelEkle(p4); //Mudur eklerken departman belirtilmez
        Database.personelEkle(p5); //Mudur eklerken departman belirtilmez
        Database.personelEkle(p6); //Genel Mudur eklerken departman belirtilmez
        Database.personelEkle(p14); //Genel Mudur eklerken departman belirtilmez
        Database.personelEkle(p7, Database.uretimDepartmani);
        Database.personelEkle(p8, Database.teknikHizmetlerDepartmani);
        Database.personelEkle(p9, Database.maliIslerDepartmani);
        Database.personelEkle(p10, Database.teknikHizmetlerDepartmani);
        Database.personelEkle(p11, Database.insanKaynaklariDepartmani);
        Database.personelEkle(p12, Database.uretimDepartmani);
        Database.personelEkle(p13, Database.uretimDepartmani);
        //**********************************************************************************




        //Yukaridaki personellerin girisleri yapildiktan sonra burasi calisacaktir
        Uygulama.personelTakipSistemi();


    }
}
