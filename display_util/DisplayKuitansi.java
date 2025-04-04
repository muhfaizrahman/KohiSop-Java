package display_util;

import channel_pembayaran.Pembayaran;
import mata_uang.IMataUang;
import mata_uang.MataUang;
import menu.Makanan;
import menu.Minuman;
import pemesanan.PesananMakanan;
import pemesanan.PesananMinuman;
import perhitungan.HitungHarga;
import perhitungan.Pajak;

public class DisplayKuitansi {
    public static void displayKuitansi(Pembayaran pembayaran) {

        IMataUang mataUang = MataUang.getMataUang();
        String mataUangString = mataUang.getClass().getSimpleName();
        double totalPajak = Pajak.getPajakTotal();

        double hargaSebelumPerhitunganIDR = HitungHarga.hitungTotalHarga();
        double totalTagihanSebelumPerhitungan = mataUang.konversiDariIDR(hargaSebelumPerhitunganIDR);
        
        double totalHargaIDR = (hargaSebelumPerhitunganIDR * (1 - pembayaran.getDiskon())) + pembayaran.getBiayaAdmin() + totalPajak;
        double totalTagihanSetelahPerhitungan = mataUang.konversiDariIDR(totalHargaIDR);

        int totalHargaMinuman = HitungHarga.hitungTagihanKategoriMinuman();
        int totalPajakMinuman = Pajak.getPajakKategoriMinuman();
        int totalHargaMakanan = HitungHarga.hitungTagihanKategoriMakanan();
        int totalPajakMakanan = Pajak.getPajakKategoriMakanan();

        System.out.printf("|%-117s|\n", "-----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %46s%s%45s |\n", "","Kuitansi Pembelian KohiSop", "");

        if (!PesananMakanan.getMap().isEmpty()) {
            System.out.printf("|%-117s|\n", "-----------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %50s%s%51s |\n", "","Kategori Makanan", "");
            System.out.printf("|%-117s|\n", "-----------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-5s | %-40s | %-10s | %-10s | %-12s | %-10s | %-12s |\n", "Kode", "Menu Makanan", "Harga", "Jumlah", "Total Harga", "Pajak", "Total Pajak");
            System.out.printf("|%s|%s|%s|%s|%s|%s|%s|\n", "-------", "------------------------------------------", "------------", "------------", "--------------", "------------", "--------------");
            
            for (String kode : PesananMakanan.getMap().keySet()) {
                Makanan makanan = Makanan.daftarMakanan.get(kode);
                System.out.printf("| %-5s | %-40s | %-10d | %-10d | %-12d | %-10s | %-12s |\n", makanan.getKode(), makanan.getNama(), makanan.getHarga(), PesananMakanan.getMap().get(kode), HitungHarga.hitungTotalMakanan(kode), Pajak.getPajakMakanan(kode), Pajak.getPajakMakananPerJenis(kode));
            }
            
            System.out.printf("|%s|%s|%s|%s|%s|%s|%s|\n", "-------", "------------------------------------------", "------------", "------------", "--------------", "------------", "--------------");
            System.out.printf("| Total harga makanan di luar pajak: %-83d|\n", totalHargaMakanan);
            System.out.printf("| Total harga makanan termasuk pajak: %-82d|\n", totalHargaMakanan + totalPajakMakanan);
        }
    
        if (!PesananMinuman.getMap().isEmpty()) {
            System.out.printf("|%-117s|\n", "-----------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %50s%s%51s |\n", "","Kategori Minuman", "");
            System.out.printf("|%-117s|\n", "-----------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-5s | %-40s | %-10s | %-10s | %-12s | %-10s | %-12s |\n", "Kode", "Menu Minuman", "Harga", "Jumlah", "Total Harga", "Pajak", "Total Pajak");
            System.out.printf("|%s|%s|%s|%s|%s|%s|%s|\n", "-------", "------------------------------------------", "------------", "------------", "--------------", "------------", "--------------");
            
            for (String kode : PesananMinuman.getMap().keySet()) {
                Minuman minuman = Minuman.daftarMinuman.get(kode);
                System.out.printf("| %-5s | %-40s | %-10d | %-10d | %-12d | %-10s | %-12s |\n", minuman.getKode(), minuman.getNama(), minuman.getHarga(), PesananMinuman.getMap().get(kode), HitungHarga.hitungTotalMinuman(kode), Pajak.getPajakMinuman(kode), Pajak.getPajakMinumanPerJenis(kode));
            }

            System.out.printf("|%s|%s|%s|%s|%s|%s|%s|\n", "-------", "------------------------------------------", "------------", "------------", "--------------", "------------", "--------------");
            System.out.printf("| Total harga minuman di luar pajak: %-83d|\n", totalHargaMinuman);
            System.out.printf("| Total harga minuman termasuk pajak: %-82d|\n", totalHargaMinuman + totalPajakMinuman);
            System.out.printf("|%-117s|\n", "-----------------------------------------------------------------------------------------------------------------------");
        }
        
        // Total tagihan dengan mata uang pembayaran
        System.out.printf("|%-117s|\n", "-----------------------------------------------------------------------------------------------------------------------");
        
        System.out.printf("| %-50s: %10.2f%% %54s|\n", "Diskon channel pembayaran " + pembayaran.getClass().getSimpleName(), pembayaran.getDiskon() * 100, "");

        System.out.printf("| %-50s: %10.2f %-10s %44s|\n", "Biaya admin channel pembayaran " + pembayaran.getClass().getSimpleName(), mataUang.konversiDariIDR(pembayaran.getBiayaAdmin()), mataUangString, "");

        System.out.printf("| %-50s: %10.2f %-10s %44s|\n", "Total pajak pesanan", totalPajak, mataUangString, "");

        System.out.printf("| %-50s: %10.2f %-10s %44s|\n", "Total tagihan pesanan sebelum perhitungan", totalTagihanSebelumPerhitungan, mataUangString, "");
            
        System.out.printf("| %-50s: %10.2f %-10s %44s|\n", "Total tagihan pesanan setelah perhitungan", totalTagihanSetelahPerhitungan, mataUangString, "");

        System.out.printf("|%-117s|\n", "-----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %39s%s%38s |\n", "","Terima kasih dan silakan datang kembali.", "");
        System.out.printf("|%-117s|\n", "-----------------------------------------------------------------------------------------------------------------------");
    }
}
