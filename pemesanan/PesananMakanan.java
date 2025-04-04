package pemesanan;

import java.util.HashMap;
import java.util.Map;
import menu.Makanan;

public class PesananMakanan extends MenuPesanan {
    private static Map<String, Integer> jumlahMakanan = new HashMap<>();

    public PesananMakanan() {
        super(jumlahMakanan, 5, 2, "Makanan");
    }

    public void pesan(String kode) {
        super.pesan(kode, Makanan.daftarMakanan);
    }

    public static Map<String, Integer> getMap() {
        return jumlahMakanan;
    }
}
