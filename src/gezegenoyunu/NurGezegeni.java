/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gezegenoyunu;

class NurGezegeni extends Gezegen{ //Constructor
     public NurGezegeni(int xKonum, int yKonum){
        super("Nur Gezegeni", xKonum, yKonum, 28, "Temiz" , 6);
    } 
    
    public void gezegenOzellikleriGoster(){ //Gezegenin ozelliklerini yazdirir.
        super.cisimBilgisiGoster();
        System.out.println("Gezegenin Ismi: " + isim);
        System.out.println("Gezegenin Konumu: (" + xKonum + "," + yKonum + ")");
        System.out.println("Gezegenin Kaynak Miktari: " + kaynakMiktari);
        System.out.println("Gezegenin Atmosfer Durumu: " + atmosferDurumu);
        System.out.println("Gezegenin Yer Cekim Degeri: " + yerCekimi);
    }
    
//   @Override
    public int inisMaliyetiHesaplama(){
        return yerCekimi * 2;
    }
    
//    @Override
    public int kalkisMaliyetiHesaplama (){
        return yerCekimi * 3;
    }

}
