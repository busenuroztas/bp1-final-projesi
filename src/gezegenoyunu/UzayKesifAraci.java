
package gezegenoyunu;

public class UzayKesifAraci {

    int[] konum;
    int yakitSeviyesi; //Mevcut yakit seyiyesidir.
    int kapasite; //Maksimum kaynak kapasitesini simgeler.
    int mevcutKaynak; //Su anki kaynak miktarini gosterir.
    String durum;   //Uzay kesif aracinin hareket durumunu gosterir.

    public UzayKesifAraci() { //Constructor.
        this.konum=new int [] {0,0};
        this.yakitSeviyesi = 100; //Baslangic yakit seviyesidir.
        this.kapasite = 50; //Baslangic kapasitesidir.
        this.mevcutKaynak = 0; //Baslangicta kaynak yoktur.
        this.durum = "Duragan"; //Baslangicta uzay kesif araci duragandir.
    }

    public void durumGoster() { //Uzay kesif aracinin durumunu gosterir.
        System.out.println("***Uzay Kesif Araci Durumu***");
        System.out.println("Yakit Seviyesi: " + yakitSeviyesi);
        System.out.println("Kaynak Kapasitesi: " + mevcutKaynak);
        System.out.println("Durum: " + durum);
        System.out.println("-------------------------------------");
    }

    public boolean hareketEt(int maliyet) { //Hareket etmeye ve yakit tuketmeye yarar.
        if (yakitSeviyesi >= maliyet) {
            yakitSeviyesi -= maliyet;
            return true;
        } else {
            System.out.println("Yeterli Yakit Yok!!");
            return false;
        }
    }

    public void kaynakTopla(int miktar) { //Kaynak toplamayi saglar.
        if (mevcutKaynak + miktar <= kapasite) {
            mevcutKaynak += miktar;
            System.out.println(miktar + "birim kaynak toplandi.");
        } else {
            System.out.println("Yeterli kaynak yok!! Sadece " + (kapasite - mevcutKaynak) + " birim kaynak toplanabilir.");
            mevcutKaynak = kapasite; //Kapasiteyi tamamen doldurur.
        }
    }

    public void yakitYenile(int kaynakMiktari) { //Yakit yenilememizi saglar.
        int eklenecekYakit = kaynakMiktari * 2; //1 kaynak = 2 birim yakit
        mevcutKaynak -= kaynakMiktari;
        yakitSeviyesi += eklenecekYakit;
        System.out.println(kaynakMiktari + " birim kaynak kullanilarak " + eklenecekYakit + " birim yakit eklendi.");
    }

    public void aracGelistir(int kaynakMiktari) { //Kapasiteyi arttirarak araci gelistirir.
        int kapasiteArtisi = kaynakMiktari * 5; //1 kaynak = 5 kapasite
        mevcutKaynak -= kaynakMiktari;
        kapasite += kapasiteArtisi;
        System.out.println(kaynakMiktari + " birim kaynak kullanilarak " + kapasiteArtisi + " birim kapasite eklendi.");
    }

    public int getYakitSeviyesi() {
        return yakitSeviyesi;
    }

    public int getMevcutKaynak() {
        return mevcutKaynak;
    }

    public void gezegeneGit(Gezegen gezegen) {
        int maliyet = Math.abs(gezegen.xKonum) + Math.abs(gezegen.yKonum);
        if (yakitSeviyesi >= maliyet) {
            yakitSeviyesi -= maliyet;
            System.out.println(gezegen.isim + "gezegenine gidildi---->");
        } else {
            System.out.println("Yeterli yakit yok!!");
        }
    }
    
    public void konumGuncelle(int [] yeniKonum){
        this.konum[0]= yeniKonum[0];
        this.konum[1]= yeniKonum[1];
        System.out.println("Uzay araci yeni konuma tasindi: [" + yeniKonum[0] + ", " + yeniKonum[1] + "]");
        
    }
            
}
