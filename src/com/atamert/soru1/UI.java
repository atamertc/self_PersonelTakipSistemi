package com.atamert.soru1;

import java.util.Scanner;

public class UI {
    static Scanner scanner = new Scanner(System.in);

    public static void anaMenu() {
        System.out.println("==============================================");
        System.out.println("|           PERSONEL TAKIP SISTEMI           |");
        System.out.println("==============================================");
        System.out.println("|     1-Personel Islemleri                   |");
        System.out.println("|     2-Muhasebe Islemleri                   |");
        System.out.println("|     3-Raporlamalar                         |");
        System.out.println("|     0-Cikis                                |");
        System.out.println("==============================================");
    }

    public static void personelMenu() {
        System.out.println();
        System.out.println("***************************************");
        System.out.println("*         Personel Islemleri          *");
        System.out.println("***************************************");
        System.out.println("*       1-Personel Ekleme             *");
        System.out.println("*       2-Personel Listesi            *");
        System.out.println("*       3-Personel Silme              *");
        System.out.println("*       4-Departman Ekleme            *");
        System.out.println("*       5-Departman Listesi           *");
        System.out.println("*       0-Onceki Menu                 *");
        System.out.println("***************************************");
    }

    public static void muhasebeMenu() {
        System.out.println();
        System.out.println("***************************************");
        System.out.println("*         Muhasebe Islemleri          *");
        System.out.println("***************************************");
        System.out.println("*       1-Personele Maas Tanimla      *");
        System.out.println("*       2-Personel Maas Duzenle       *");
        System.out.println("*       3-Odeme Listesi               *");
        System.out.println("*       0-Onceki Menu                 *");
        System.out.println("***************************************");
    }

    public static void raporlamaMenu() {
        System.out.println();
        System.out.println("*********************************************************");
        System.out.println("*                     Raporlamalar                      *");
        System.out.println("*********************************************************");
        System.out.println("*   1-Departman Personel Listesi                        *");
        System.out.println("*   2-En Cok Personel Bulunan Departman                 *");
        System.out.println("*   3-Departmanlara Gore Maas Ortalamalari              *");
        System.out.println("*   4-G.Mudurlerin Sorumlu Oldugu Departman Listesi     *");
        System.out.println("*   5-Kayit Tarihine Gore Personellerin Sirali Listesi  *");
        System.out.println("*   6-Ayni Gun Ise Baslayan Personellerin Listesi       *");
        System.out.println("*   0-Onceki Menu                                       *");
        System.out.println("*********************************************************");
    }



}
