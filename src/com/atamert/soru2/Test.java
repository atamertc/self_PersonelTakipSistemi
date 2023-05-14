package com.atamert.soru2;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<Personel2> personelListesi = new ArrayList<>();
        personelListesi.add(new Personel2("Ahmet", 30));
        personelListesi.add(new Personel2("Ayşe", 25));
        personelListesi.add(new Personel2("Mehmet", 35));
        personelListesi.add(new Personel2("Fatma", 28));
        personelListesi.add(new Personel2("Ali", 32));
        personelListesi.add(new Personel2("Zeynep", 29));
        personelListesi.add(new Personel2("Mustafa", 40));
        personelListesi.add(new Personel2("Esra", 27));
        personelListesi.add(new Personel2("Ömer", 33));
        personelListesi.add(new Personel2("Gül", 26));
        personelListesi.add(new Personel2("Hakan", 31));
        personelListesi.add(new Personel2("Elif", 24));
        personelListesi.add(new Personel2("Serkan", 38));
        personelListesi.add(new Personel2("Deniz", 23));
        personelListesi.add(new Personel2("Sevgi", 30));
        personelListesi.add(new Personel2("Murat", 37));
        personelListesi.add(new Personel2("Selin", 22));
        personelListesi.add(new Personel2("Cem", 29));
        personelListesi.add(new Personel2("Pınar", 36));
        personelListesi.add(new Personel2("Emre", 27));

        //1. Yaşı 30'dan büyük olan personellerin sayısını bulunuz.
        long otuzdanBuyukSayisi = personelListesi.stream()
                .filter(x -> x.getYas() > 30)
                .count();
        System.out.println("Yasi 30'dan buyuklerin sayisi: " + otuzdanBuyukSayisi);
        System.out.println("----------------------------------------------------");
        //2. İsimleri "A" harfiyle başlayan personellerin sayısı
        long aHarfiyleBaslayanSayisi = personelListesi.stream()
                .filter(x -> x.getAd().charAt(0) == 'A')
                .count();
        System.out.println("Ismi A ile baslayan sayisi: " + aHarfiyleBaslayanSayisi);
        System.out.println("----------------------------------------------------");
        //3. Yaşı en büyük olan personelin adı
        personelListesi.stream()
                .sorted(Comparator.comparingInt(Personel2::getYas).reversed())
                .map(x->x.getAd())
                .limit(1)
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        //4. İsmi "Ali" olan personelin yaşı
        personelListesi.stream()
                .filter(x->x.getAd().equalsIgnoreCase("Ali"))
                .map(Personel2::getYas)
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        //5. Yaşı en küçük olan 3 personelin isimleri
        personelListesi.stream()
                .sorted(Comparator.comparingInt(Personel2::getYas))
                .map(x->x.getAd())
                .limit(3)
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        //6. Yaşı 25 ile 35 arasında olan personellerin sayısı
        long yasi25Ile35Sayisi = personelListesi.stream()
                .filter(x -> x.getYas() > 25 && x.getYas() < 35)
                .count();
        System.out.println("Yasi 25 ile 35 arasi sayisi: " + yasi25Ile35Sayisi);
        System.out.println("----------------------------------------------------");
        //7. İsimleri 4 harften uzun olan personellerin isimleri
        personelListesi.stream()
                .filter(x->x.getAd().length() > 4)
                .map(Personel2::getAd)
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        //8. Yaşı en büyük 2 personelin isimleri
        personelListesi.stream()
                .sorted(Comparator.comparingInt(Personel2::getYas).reversed())
                .map(x->x.getAd())
                .limit(2)
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        //9. İsimleri "a" harfi ile biten personellerin isimleri, büyük harf dönüşümü yapılarak yazdırınız.
        personelListesi.stream()
                .filter(x->x.getAd().charAt(x.getAd().length()-1) == 'a')
                .map(x->x.getAd().toUpperCase())
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        //10. İsimlerin uzunluğunun ortalaması kaçtır?
        Integer toplam = personelListesi.stream()
                .map(x -> x.getAd().length())
                .reduce(0, (x, y) -> x + y);
        long adet = personelListesi.stream()
                .count();
        System.out.println("Isimlerin uzunluk ortalamasi: "+((double)toplam/adet));
        System.out.println("----------------------------------------------------");
        //11. İsmi en uzun olan personelin yaşı kaçtır ?
        Optional<Personel2> enUzunIsimliPersonel = personelListesi.stream()
                .max(Comparator.comparingInt(p -> p.getAd().length()));
        System.out.println(enUzunIsimliPersonel.get().getYas());
        System.out.println("----------------------------------------------------");
        //12. İsimlerin herhangi biri "ahmet" mi? (boolean dönüş yapmalı)
        boolean check = personelListesi.stream()
                .anyMatch(x -> x.getAd().equalsIgnoreCase("ahmet"));
        System.out.println(check);
        System.out.println("----------------------------------------------------");
        //13. İsimleri ters çevirilmiş olarak alfabetik olarak sıralanmış bir liste oluşturun.
        List<String> tersIsimler = personelListesi.stream()
                .map(x -> new StringBuilder(x.getAd()).reverse().toString())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(tersIsimler);
        System.out.println("----------------------------------------------------");
        //14. İsimlerinde "e" harfi geçen personellerin isimlerini bir listeye ekleyin.
        List<String> eHarfiGecenIsimler = personelListesi.stream()
                .filter(x -> x.getAd().contains("e"))
                .map(Personel2::getAd)
                .collect(Collectors.toList());
        System.out.println(eHarfiGecenIsimler);
        System.out.println("----------------------------------------------------");
        //15. Yaşı en küçük olan personelin adı ve yaşını bir Map olarak döndürün.
        Map<String, Integer> enKucukYas = personelListesi.stream()
                .min(Comparator.comparing(Personel2::getYas))
                .map(p -> Map.of(p.getAd(), p.getYas()))
                .orElse(Collections.emptyMap());
        System.out.println(enKucukYas);






    }
}
