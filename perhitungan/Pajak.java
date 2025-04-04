package perhitungan;

import menu.Makanan;
import menu.Minuman;
import pemesanan.PesananMakanan;
import pemesanan.PesananMinuman;

public class Pajak {

    // Get Pajak
    public static int getPajakMinuman(String kode) {
        Minuman minuman = Minuman.daftarMinuman.get(kode);
        if (minuman.getHarga() < 50) {
            return 0;
        } else if (minuman.getHarga() >= 50 && minuman.getHarga() <= 55) {
            return (int) (minuman.getHarga() * 0.08);
        } else {
            return (int) (minuman.getHarga() * 0.11);
        }
    }
    
    public static int getPajakMakanan(String kode) {
        Makanan makanan = Makanan.daftarMakanan.get(kode);
        if (makanan.getHarga() < 50) {
            return (int) (makanan.getHarga() * 0.11);
        } else {
            return (int) (makanan.getHarga() * 0.08);
        }
    }

    public static int getPajakMinumanPerJenis(String kode) {
        return getPajakMinuman(kode) * PesananMinuman.getMap().get(kode);
    }

    public static int getPajakMakananPerJenis(String kode) {
        return getPajakMakanan(kode) * PesananMakanan.getMap().get(kode);
    }

    public static int getPajakKategoriMakanan() {
        int total = 0;
        for (String kode : PesananMakanan.getMap().keySet()) {
            total += getPajakMakananPerJenis(kode);
        } 
        return total;
    }

    public static int getPajakKategoriMinuman() {
        int total = 0;
        for (String kode : PesananMinuman.getMap().keySet()) {
            total += getPajakMinumanPerJenis(kode);
        } 
        return total;
    }

    public static int getPajakTotal() {
        return getPajakKategoriMakanan() + getPajakKategoriMinuman();
    }
}
