package display_util;

import menu.Makanan;
import menu.Minuman;
import pemesanan.PesananMakanan;
import pemesanan.PesananMinuman;

public class DisplayPesanan {
    public static void displayPesanan() {
        if (!PesananMakanan.getMap().isEmpty()) {
            System.out.println("|-------|------------------------------------------|------------|");
            System.out.printf("| %-5s | %-40s | %-10s |\n", "Kode", "Makanan", "Kuantitas");
            System.out.println("|-------|------------------------------------------|------------|");
            for (String kode : PesananMakanan.getMap().keySet()) {
                Makanan makanan = Makanan.daftarMakanan.get(kode);
                System.out.printf("| %-5s | %-40s | %-10d |\n", makanan.getKode(), makanan.getNama(), PesananMakanan.getMap().get(kode));
            }
        }
        
        if (!PesananMinuman.getMap().isEmpty()) {
            System.out.println("|-------|------------------------------------------|------------|");
            System.out.printf("| %-5s | %-40s | %-10s |\n", "Kode", "Minuman", "Kuantitas");
            System.out.println("|-------|------------------------------------------|------------|");
            for (String kode : PesananMinuman.getMap().keySet()) {
                Minuman minuman = Minuman.daftarMinuman.get(kode);
                System.out.printf("| %-5s | %-40s | %-10d |\n", minuman.getKode(), minuman.getNama(), PesananMinuman.getMap().get(kode));
            }
            System.out.println("|-------|------------------------------------------|------------|");
        }
    }
}
