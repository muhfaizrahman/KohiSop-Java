package menu;

import java.util.LinkedHashMap;
import java.util.Map;

public class Makanan extends Menu {
    public static Map<String, Makanan> daftarMakanan = new LinkedHashMap<>();

    Makanan(String kode, String nama, int harga) {
        super(kode, nama, harga);
        daftarMakanan.put(kode, this);
    }

    static {
        new Makanan("M1", "Petemania Pizza", 112);
        new Makanan("M2", "Mie Rebus Super Mario", 35);
        new Makanan("M3", "Ayam Bakar Goreng Rebus Spesial", 72);
        new Makanan("M4", "Soto Kambing Iga Guling", 124);
        new Makanan("S1", "Singkong Bakar A La Carte", 37);
        new Makanan("S2", "Ubi Cilembu Bakar Arang", 58);
        new Makanan("S3", "Tempe Mendoan", 18);
        new Makanan("S4", "Tahu Bakso Extra Telur", 28);
    }
    
    @Override
    public void display() {
        System.out.printf("| %-5s | %-40s | %-10d |\n", kode, nama, harga);
    }
}
