package perhitungan;

import menu.Makanan;
import menu.Minuman;
import pemesanan.PesananMakanan;
import pemesanan.PesananMinuman;

public class HitungHarga {

    public static int hitungTotalMakanan(String kode) {
        return Makanan.daftarMakanan.get(kode).getHarga() * PesananMakanan.getMap().get(kode);
    }
    
    public static int hitungTotalMinuman(String kode) {
        return Minuman.daftarMinuman.get(kode).getHarga() * PesananMinuman.getMap().get(kode);
    }

    public static int hitungTagihanKategoriMakanan() {
        int total = 0;
        for (String kode : PesananMakanan.getMap().keySet()) {
            total += hitungTotalMakanan(kode);
        }
        return total;
    }

    public static int hitungTagihanKategoriMinuman() {
        int total = 0;
        for (String kode : PesananMinuman.getMap().keySet()) {
            total += hitungTotalMinuman(kode);
        }
        return total;
    }
    
    public static int hitungTotalHarga() {
        return hitungTagihanKategoriMakanan() + hitungTagihanKategoriMinuman();
    }

}