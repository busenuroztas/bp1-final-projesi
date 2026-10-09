
package gezegenoyunu;

import java.util.Random;

public class Galaksi {

    Cisim[] cisimler;
    int cisimSayisi;

    public Galaksi() { //Galaksi icin olusturdugumuz parametresiz constructor.

    }

    public Galaksi(int toplamCisimSayisi) { //Parametreli constructor.
        cisimler = new Cisim[toplamCisimSayisi];
        cisimSayisi = 0;
    }

    public void galaksiOlustur(int gezegenSayisi, int karadelikSayisi) { //Galaksiyi rastgele olusturmak icindir.
        Random random = new Random();

        for (int i = 0; i < gezegenSayisi; i++) { //Gezegenleri ekler.
            String isim = "Gezegen-" + (i + 1);
            int x = random.nextInt(100); // Haritanin boyutlari
            int y = random.nextInt(100);
            Gezegen yeniGezegen = new Gezegen(isim, x, y);
            cisimEkle(yeniGezegen);
        }

        for (int i = 0; i < karadelikSayisi; i++) { //Karadelikleri ekler.
            String isim = "Karadelik-" + (i + 1);
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            Karadelik yeniKaradelik = new Karadelik(isim, x, y);
            cisimEkle(yeniKaradelik);
        }
    }

    public void cisimEkle(Cisim cisim) {
        System.out.println("***Galaksi Haritasi***");

        for (int i = 0; i < cisimSayisi; i++) {
            cisimler[cisimSayisi++] = cisim;
            cisimler[i].cisimBilgisiGoster();
            System.out.println("--------------------");
        }
    }

    public void galaksiHaritasiniGoster() { //Galaksi haritasini gosterir.
        System.out.println("***Galaksi Haritasi***");
        for (int i = 0; i < cisimSayisi; i++) {
            cisimler[i].cisimBilgisiGoster();
            System.out.println("-----------------------------");
        }
    }

    public Cisim[] getCisimler() {
        return cisimler;
    }

    public void gezegenEkle(String isim, int kaynak, String atmosfer, int yerCekimi, int x, int y) {
        if (cisimSayisi < cisimler.length) {
            cisimler[cisimSayisi++] = new Gezegen(isim, x, y);
        } else {
            System.out.println("Galaksi kapasitesi doldu!!");
        }
    }

    public void karadelikEkle(int x, int y) {
        if (cisimSayisi < cisimler.length) {

        }
    }
}
