
package gezegenoyunu;

public class Cisim {

    String isim; //Cismin ismi
    int xKonum; //x konumu
    int yKonum; //y konumu

    public Cisim(String isim, int x, int y) { // Constructor.
        this.isim = isim;
        this.xKonum = x;
        this.yKonum = y;
    }

    public String getIsim(){
        return isim;
    }
    
    public int[] getKonum() { //Cismin konumunu hesaplamaya yarar.
        return new int[]{xKonum, yKonum};
    }

    public void cisimBilgisiGoster() {
// Cismin ozelliklerini ekrana yazdirir.
    }
}
