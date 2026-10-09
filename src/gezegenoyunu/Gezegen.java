
package gezegenoyunu;

import java.util.Random;

public class Gezegen extends Cisim {

    int kaynakMiktari; // Gezegenin sahip oldugu kaynak miktarini temsil eder.
    String atmosferDurumu; //Atmosferin ozelliklerini temsil eder(yasanabilir,zehirli,yogun gibi).
    int yerCekimi; //Yer cekimini temsil eder.

    public Gezegen(String isim, int xKonum, int yKonum) { //Constuctor
        super(isim, xKonum, yKonum);
        this.isim = isim;

        Random random = new Random(); //Gezegen ozelliklerini rastgele belirlemek icin kullanilir.
        this.kaynakMiktari = random.nextInt(50) + 1; //Kaynagi 1-50 arasindan rastgele secer.
        String[] atmosferler = {"Yasanilabilir", "Zehirli", "Yogun"};
        this.atmosferDurumu = atmosferler[random.nextInt(atmosferler.length)];
        this.yerCekimi = random.nextInt(20) + 1; //Yer cekimini 1-20 arasindan rastgele secer.
    }

    public Gezegen(String isim, int xKonum,int yKonum,int kaynakMiktari,String atmosferDurumu,int yerCekimi){
        super(isim, xKonum, yKonum);
        this.isim=isim;
        this.xKonum=xKonum;
        this.yKonum=yKonum;
        this.atmosferDurumu=atmosferDurumu;
        this.kaynakMiktari=kaynakMiktari;
        this.yerCekimi=this.yerCekimi;
        
    }
    @Override 
    public void cisimBilgisiGoster() { // Gezegen bilgilerini gosterir.
        System.out.println("Gezegen: " + isim);
        System.out.println("Konum: (" + xKonum + "," + yKonum + ")");
        System.out.println("Kaynak miktari: " + kaynakMiktari);
        System.out.println("Atmosfer durumu: " + atmosferDurumu);
        System.out.println("Yer cekimi: " + yerCekimi);
    }

    public int getKaynakMiktari() { //Kaynak miktarini dondurur.
        return kaynakMiktari;
    }

    public int getYerCekimi() {
        return yerCekimi;
    }

    public void kaynakTuket(int miktar) { //Tuketilen kaynak miktarini hesaplar.
        this.kaynakMiktari = Math.max(this.kaynakMiktari - miktar, 0);
    }

    public int inisMaliyetiHesapla() { //Inis maliyetini hesaplamak icin kullandik.
        return yerCekimi * 2; 
    }
}
