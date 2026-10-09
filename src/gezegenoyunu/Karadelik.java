
package gezegenoyunu;

import java.util.Random;

public class Karadelik extends Cisim {

    public Karadelik(String isim, int xKonum, int yKonum) { //Constructor
        super(isim, xKonum, yKonum); //Super class'inin (Cisim) constructor'ini cagirir.
    }

    public String etkilesim() {
        return Math.random() < 0.5 ? "Yakit ucretsiz" : "Kaynak ve yakit kaybi";
    }

    @Override
    public void cisimBilgisiGoster() { //Karadeligin bilgilerini gosterir.
        System.out.println("Karadelik: " + isim);
        System.out.println("Konum: (" + xKonum + "," + yKonum + ")");
    }

    public int[] karadelikEtkisi(int maxX, int maxY) { //Karadeligin etkisini gosterir.
        Random random = new Random();
        int[] yeniKonum = {random.nextInt(maxX), random.nextInt(maxY)};
        System.out.println("Karadelik sizi rastgele bir konuma gonderdi: (" + yeniKonum[0] + "," + yeniKonum[1] + ")");
        return yeniKonum;

    }
}
