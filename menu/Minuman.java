package menu;

import java.util.LinkedHashMap;
import java.util.Map;

public class Minuman extends Menu {
    public static Map<String, Minuman> daftarMinuman = new LinkedHashMap<>();

    Minuman(String kode, String nama, int harga) {
        super(kode, nama, harga);
        daftarMinuman.put(kode, this);
    }

    static {
        new Minuman("A1", "Caffe Latte", 46);
        new Minuman("A2", "Cappuccino", 46);
        new Minuman("E1", "Caffe Americano", 37);
        new Minuman("E2", "Caffe Mocha", 55);
        new Minuman("E3", "Caramel Macchiato", 59);
        new Minuman("E4", "Asian Dolce Latte", 55);
        new Minuman("E5", "Double Shots Iced Shaken Espresso", 50);
        new Minuman("B1", "Freshly Brewed Coffee", 23);
        new Minuman("B2", "Vanilla Sweet Cream Cold Brew", 50);
        new Minuman("B3", "Cold Brew", 44);
    }
    
    @Override
    public void display() {
        System.out.printf("| %-5s | %-40s | %-10d |\n", kode, nama, harga);
    }
}
