package com.atamert.soru1.personelTipleri;

import com.atamert.soru1.Database;
import com.atamert.soru1.Departman;
import com.atamert.soru1.Personel;
import com.atamert.soru1.exceptions.GenelMudurAtamaException;
import com.atamert.soru1.exceptions.MudurAtamaException;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

public class Mudur extends Personel {
    private String sicilNo;
    private Departman sorumluDepartman;

    public Mudur(String ad, String soyad, int yas, String sicilNo) {
        super(ad, soyad, yas);
        super.setUnvan("Mudur");
        this.sicilNo = sicilNo;
        this.sorumluDepartman = mudurDepartmanAta();
    }

    public Mudur(String ad, String soyad, int yas, String sicilNo, LocalDate localDate, Departman sorumluDepartman) {
        super(ad, soyad, yas, localDate);
        super.setUnvan("Mudur");
        this.sorumluDepartman = sorumluDepartman;
        sorumluDepartman.setMudur(this);
    }

    public Mudur(String ad, String soyad, int yas, double maas, String sicilNo, LocalDate localDate, Departman sorumluDepartman) {
        super(ad, soyad, yas, maas, localDate);
        super.setUnvan("Mudur");
        this.sorumluDepartman = sorumluDepartman;
        sorumluDepartman.setMudur(this);
    }

    private Departman mudurDepartmanAta() {
        Scanner scanner = new Scanner(System.in);
        int secim = 0;
        do {
            System.out.println("Mudure atanacak departmani seciniz");
            System.out.println("1- Teknik Hizmetler Departmani");
            System.out.println("2- Insan Kaynaklari Departmani");
            System.out.println("3- Uretim Departmani");
            System.out.println("4- Satin Alma Departmani");
            System.out.println("5- Mali Isler Departmani");
            System.out.println("0- Bitti");
            secim = Integer.parseInt(scanner.nextLine());
            switch (secim) {
                case 1 -> {
                    if (Database.teknikHizmetlerDepartmani.getMudur() == null) {
                        sorumluDepartman = Database.teknikHizmetlerDepartmani;
                        System.out.println(this.getAd() + " " + this.getSoyad() +
                                " isimli Mudure -> Teknik Hizmetler Departmani atandi");
                        sorumluDepartman.setMudur(this);
                    } else {
                        try {
                            throw new MudurAtamaException();
                        } catch (MudurAtamaException e) {
                            e.printStackTrace();
                        }
                    }
                }
                case 2 -> {
                    if (Database.insanKaynaklariDepartmani.getMudur() == null) {
                        sorumluDepartman = Database.insanKaynaklariDepartmani;
                        System.out.println(this.getAd() + " " + this.getSoyad() +
                                " isimli Mudure -> Insan Kaynaklari Departmani atandi");
                        sorumluDepartman.setMudur(this);
                    } else {
                        try {
                            throw new MudurAtamaException();
                        } catch (MudurAtamaException e) {
                            e.printStackTrace();
                        }
                    }
                }
                case 3 -> {
                    if (Database.uretimDepartmani.getMudur() == null) {
                        sorumluDepartman = Database.uretimDepartmani;
                        System.out.println(this.getAd() + " " + this.getSoyad() +
                                " isimli Mudure -> Uretim Departmani atandi");
                        sorumluDepartman.setMudur(this);
                    } else {
                        try {
                            throw new MudurAtamaException();
                        } catch (MudurAtamaException e) {
                            e.printStackTrace();
                        }
                    }
                }
                case 4 -> {
                    if (Database.satinAlmaDepartmani.getMudur() == null) {
                        sorumluDepartman = Database.satinAlmaDepartmani;
                        System.out.println(this.getAd() + " " + this.getSoyad() +
                                " isimli Mudure -> Satin Alma Departmani atandi");
                        sorumluDepartman.setMudur(this);
                    } else {
                        try {
                            throw new MudurAtamaException();
                        } catch (MudurAtamaException e) {
                            e.printStackTrace();
                        }
                    }
                }
                case 5 -> {
                    if (Database.maliIslerDepartmani.getMudur() == null) {
                        sorumluDepartman = Database.maliIslerDepartmani;
                        System.out.println(this.getAd() + " " + this.getSoyad() +
                                " isimli Mudure -> Mali Isler Departmani atandi");
                        sorumluDepartman.setMudur(this);
                    } else {
                        try {
                            throw new MudurAtamaException();
                        } catch (MudurAtamaException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } while (secim != 0);
        return sorumluDepartman;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }

    public Departman getSorumluDepartman() {
        return sorumluDepartman;
    }

    public void setSorumluDepartman(Departman sorumluDepartman) {
        this.sorumluDepartman = sorumluDepartman;
    }
}

