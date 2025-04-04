package pemesanan;

import java.util.HashMap;
import java.util.Map;
import menu.Minuman;

public class PesananMinuman extends MenuPesanan {
    private static Map<String, Integer> jumlahMinuman = new HashMap<>();

    public PesananMinuman() {
        super(jumlahMinuman, 5, 3, "Minuman");
    }

    public void pesan(String kode) {
        super.pesan(kode, Minuman.daftarMinuman);
    }

    public static Map<String, Integer> getMap() {
        return jumlahMinuman;
    }
}
