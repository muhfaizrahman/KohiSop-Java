import java.util.*;

import channel_pembayaran.EMoney;
import channel_pembayaran.Pembayaran;
import channel_pembayaran.QRIS;
import channel_pembayaran.Tunai;
import display_util.DisplayKuitansi;
import display_util.DisplayMenu;
import display_util.DisplayPesanan;
import mata_uang.*;
import menu.*;
import pemesanan.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Pesanan pesanan = new Pesanan();
        PesananMakanan pesananMakanan = new PesananMakanan();
        PesananMinuman pesananMinuman = new PesananMinuman();

        DisplayMenu.displayMenu();
        
        while (true) {
            System.out.println("Ketik \"YES\" untuk menyeselaikan pesanan. Ketik \"CC\" untuk membatalkan pesanan.");
            System.out.println("Masukkan kode pemesanan: ");
            String kode = input.next().toUpperCase();
            
            // Case user "CC"
            if (kode.equals("CC")) {
                System.out.println("Pesanan dibatalkan oleh user. Program berhenti.");
                System.exit(0);
            }
            
            // Case user "yes"
            if (kode.equals("YES")) {
                break;
            }
            
            if (Makanan.daftarMakanan.containsKey(kode)) {
                pesananMakanan.pesan(kode);
            } else if (Minuman.daftarMinuman.containsKey(kode)) {
                pesananMinuman.pesan(kode);
            } else {
                System.out.println("Error: Kode tidak ditemukan. Coba lagi.");
            }
            DisplayPesanan.displayPesanan();
        }

        IMataUang mataUang = MataUang.pilihMataUang();
        MataUang.seMataUang(mataUang);

        Pembayaran pembayaran = null;

        while (pembayaran == null) {
            System.out.println("Pilih metode pembayaran: \nTunai\nQRIS\nEMoney");
            String pilih = input.next().toUpperCase();
    
            switch (pilih) {
                case "TUNAI":
                    pembayaran = new Tunai();
                    pembayaran.bayar(input);
                    break;
                case "QRIS":
                    pembayaran = new QRIS();
                    pembayaran.bayar(input);
                    break;
                case "EMONEY":
                    pembayaran = new EMoney();
                    pembayaran.bayar(input);
                    break;
                default:
                    System.out.println("Error: Metode pembayaran tidak ditemukan. Coba lagi.");
                    continue;
            }
            
        }

        DisplayKuitansi.displayKuitansi(pembayaran);

        input.close();
    }
}