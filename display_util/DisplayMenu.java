package display_util;

import menu.Makanan;
import menu.Minuman;

public class DisplayMenu {
    public static void displayMenu() {
        System.out.println("|-------|------------------------------------------|------------|");
        System.out.printf("| %-5s | %-40s | %-10s |\n", "Kode", "Menu Minuman", "Harga (Rp)");
        System.out.println("|-------|------------------------------------------|------------|");
        for (Minuman minuman : Minuman.daftarMinuman.values()) {
            minuman.display();
        }
        System.out.println("|-------|------------------------------------------|------------|");
        System.out.printf("| %-5s | %-40s | %-10s |\n", "Kode", "Menu Makanan", "Harga (Rp)");
        System.out.println("|-------|------------------------------------------|------------|");
        for (Makanan makanan : Makanan.daftarMakanan.values()) {
            makanan.display();
        }
        System.out.println("|-------|------------------------------------------|------------|");
    }
}
