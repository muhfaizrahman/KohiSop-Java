package pemesanan;

import java.util.Map;
import java.util.Scanner;

import menu.*;

public abstract class MenuPesanan {
    protected Scanner input = new Scanner(System.in);
    protected Map<String, Integer> daftarPesanan;
    protected int maxJenis;
    protected int maxKuantitas;
    protected String kategori;

    public MenuPesanan(Map<String, Integer> daftarPesanan, int maxJenis, int maxKuantitas, String kategori) {
        this.daftarPesanan = daftarPesanan;
        this.maxJenis = maxJenis;
        this.maxKuantitas = maxKuantitas;
        this.kategori = kategori;
    }

    public void pesan(String kode, Map<String, ? extends Menu> daftarMenu) {
        // Validasi jumlah item
        if (daftarPesanan.size() >= maxJenis) {
            System.out.println("Jumlah maksimal pemesanan " + maxJenis + " jenis item");
            return;
        }
         
        System.out.println("Ketik 'CC' untuk membatalkan pemesanan.\nKetik '0' atau 'S' untuk melewati pemesanan.\nTekan enter untuk porsi = 1.\nMasukkan jumlah porsi yang diinginkan (max " + maxKuantitas +"): ");
        String inputJumlah = input.nextLine().trim().toUpperCase();

        // Case user "CC"
        if (inputJumlah.equals("CC")) {
            System.out.println("Pesanan dibatalkan oleh user. Program berhenti.");
            System.exit(0);
        }

        // Case user isi kosong
        if (inputJumlah.equals("")) {
            inputJumlah = "1";
        }
        
        // Case user 0 / "S"
        if (inputJumlah.equals("0") || inputJumlah.equals("S")) {
            System.out.println("Melewati pemesanan menu ini...");
            return;
        }
        
        // Parse to Int
        int jumlah;
        try {
            jumlah = Integer.parseInt(inputJumlah);
        } catch (NumberFormatException e) {
            System.out.println("Error: Input tidak valid! Masukkan angka.");
            return;
        }
        
        // Validasi input jumlah
        int jumlahSaatIni = daftarPesanan.getOrDefault(kode, 0);
        if (jumlah < 0 || jumlah > maxKuantitas) {
            System.out.println("Error: Jumlah tidak valid");
            return;
        }
        
        // Jumlah maksimal porsi menu dalam 1 pemesanan
        if (jumlahSaatIni + jumlah > maxKuantitas) {
            System.out.println("Maksimal jumlah porsi " + kategori + " adalah " + maxKuantitas);
            return;
        } 

        // Penambahan menu ke dalam Map
        daftarPesanan.put(kode, jumlahSaatIni + jumlah);
        System.out.println(daftarMenu.get(kode).getNama() + " ditambahkan sebanyak " + jumlah);
        }
    }

