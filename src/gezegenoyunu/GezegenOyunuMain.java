//Buse Nur Öztaş-2321021055
//Ebrar Nur Topcu-2321021018
package gezegenoyunu;

import java.util.Scanner;

public class GezegenOyunuMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("=== UZAY KESIF OYUNU===");
        int toplamCisimSayisi = 6;
        Galaksi galaksi = new Galaksi(); //Galaksi ve uzay araci olusturur.
        galaksi.galaksiOlustur(5, 1); //5 gezegen ve 1 karadelik olusturuyor.
        UzayKesifAraci uzayAraci = new UzayKesifAraci(); //Uzay kesif aracini olusturur.

        System.out.println("Galaksiyi kesfetmeye hazir olun!");
        boolean oyunDevam = true; //Oyunun devam edip etmedigini kontrol eder.

        while (oyunDevam) {
            uzayAraci.durumGoster(); //Uzay aracinin durumunu ve galaksi haritasini gosterir.
            galaksi.galaksiHaritasiniGoster();

            System.out.println("Bir hedef secin (1-" + toplamCisimSayisi + " ): "); //Kullanicidan bir hedef secmesini istiyoruz.
            int hedefIndex = scan.nextInt() - 1;

            if (hedefIndex < 0 || hedefIndex >= toplamCisimSayisi || galaksi.getCisimler()[hedefIndex] == null) {
                System.out.println("Gecersiz secim yaptiniz. Tekrar deneyin."); //Hedef gecersizse kullaniciyi uyarir.
                continue; //Dongunun basina doner.
            } else if (hedefIndex > 0 && hedefIndex <= 10) {
                Cisim hedef = galaksi.getCisimler()[hedefIndex - 1]; // Kullanıcının seçtiği hedefi alıyoruz.
                if (hedef instanceof Gezegen) {
                    Gezegen gezegen = (Gezegen) hedef;
                    System.out.println(gezegen.getIsim() + " gezegenine gidiliyor...");
                    uzayAraci.konumGuncelle(gezegen.getKonum()); // Uzay aracının konumunu gezegene günceller.
                    gezegen.cisimBilgisiGoster(); // Gezegen bilgilerini gösterir.
                } else {
                    System.out.println("Seçtiğiniz hedef bir gezegen değil! Lütfen doğru bir hedef seçin.");
                }
            }

            Cisim hedef = galaksi.getCisimler()[hedefIndex];
            //Cismin konumunu ve yakit maliyetini hesapliyor.
            int[] uzayAraciKonum = {0, 0}; //Uzay aracinin baslangic konumu (0,0).
            int[] hedefKonum = hedef.getKonum();
            int mesafe = Math.abs(hedefKonum[0] - uzayAraciKonum[0])
                    + Math.abs(hedefKonum[1] - uzayAraciKonum[1]);
            int yakitMaliyeti = mesafe; //Mesafe kadar yakit tuketilir.

            if (!uzayAraci.hareketEt(yakitMaliyeti)) { //Uzay kesif araci hareket halinde.
                System.out.println("Yakitiniz bitti! Oyun sona erdi.");
                break;
            }

            uzayAraciKonum = hedefKonum; //Uzay aracinin konumunu gunceller.
            System.out.println(hedef.isim + " hedefine ulasildi!");

            if (hedef instanceof Gezegen) { //Hedefin bir gezegen oldugu durumda calisir.
                Gezegen gezegen = (Gezegen) hedef;
                gezegen.cisimBilgisiGoster(); //Gezegenin ozelliklerini gosterir.

                System.out.println("Ne yapmak istersiniz?");
                System.out.println("1- Kaynak topla.");
                System.out.println("2- Yakit yenile.");
                System.out.println("3- Uzay aracini gelistir.");
                System.out.println("4- Baska bir hedefe git.");

                int secim = scan.nextInt();
                switch (secim) {
                    case 1:
                        uzayAraci.kaynakTopla(gezegen.getKaynakMiktari()); //Gezegenin kaynaklarini alir.
                        gezegen.kaynakTuket(gezegen.getKaynakMiktari()); //Gezegenin kaynak miktarini azaltir.
                        break;

                    case 2:
                        System.out.println("Kac birim kaynak yakit icin kullanilacak?");
                        int kaynakMiktari = scan.nextInt();
                        if (kaynakMiktari > uzayAraci.getMevcutKaynak()) {
                            System.out.println("Yeterli kaynak yok!");
                        } else {
                            uzayAraci.yakitYenile(kaynakMiktari); //Kaynaklari yakita cevirir.
                        }
                        break;
                    case 3:
                        System.out.println("Kac birim kaynak uzay araci gelistirmek icin kullanilacak?");
                        kaynakMiktari = scan.nextInt();
                        uzayAraci.kaynakTopla(kaynakMiktari); //Uzay aracini gelistirir.
                        break;
                    case 4:
                        System.out.println("Baska bir hedefe gitmek icin geri donuluyor.");
                        break;
                    default:
                        System.out.println("Gecersiz secim yaptiniz.");
                        break;
                }
            } else if (hedef instanceof Karadelik) { //Hedefin bir karadelik oldugu durumda calisir.
                Karadelik karadelik = (Karadelik) hedef;
                karadelik.cisimBilgisiGoster(); //Karadeligin bilgilerini gosterir.

                System.out.println("Karadelige girdiniz...");
                int[] yeniKonum = karadelik.karadelikEtkisi(100, 100); //Rastgele bir konum dondurur.
                System.out.println("Yeni konum: [" + yeniKonum[0] + " , " + yeniKonum[1] + " )");
                uzayAraciKonum = yeniKonum; //Uzay aracini yeni konuma tasir.
            }
            if (uzayAraci.getYakitSeviyesi() <= 0) { //Yakit seviyesini kontrol eder. Yakit 0 ise oyun biter.
                System.out.println("Yakitiniz bitti! Oyun sona erdi.");
                oyunDevam = false;
            }
            boolean tumGezegenlerKesfedildi = true; //Kullanicinin tum gezegenleri kesfedip kesfetmedigini kontrol eder.
            for (Cisim cisim : galaksi.getCisimler()) { //Tum cisimleri kontrol eder.
                if (cisim instanceof Gezegen) {
                    Gezegen gezegen = (Gezegen) cisim;
                    if (gezegen.getKaynakMiktari() > 0) { //Gezegenin kaynaklari bitmediyse
                        tumGezegenlerKesfedildi = false; //Tüm gezegenler kesfedilmedi.
                        break;
                    }
                }
            }
            if (tumGezegenlerKesfedildi) {
                System.out.println("Tum gezegenler kesfedildi. Tebrikler!");
                oyunDevam = false;
            }
        }
        System.out.println("Oyun bitti. Katildiginiz icin tesekkurler!");

    }
}
