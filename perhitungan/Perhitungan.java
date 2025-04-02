package perhitungan;

public class Perhitungan {
    // Cek Pajak
    public double cekPajakMinuman(double harga) {
        if (harga < 50) {
            return 0.00;
        } else if (50 >= harga && harga <= 55) {
            return 0.08;
        } else {
            return 0.11;
        }
    }

    public double cekPajakMakanan(double harga) {
        if (harga >= 50) {
            return 0.08;
        } else {
            return 0.11;
        }
    }

    // Perhitungan total harga 
    // public double hitungTotalItem() {
    //     double total = 0;
    //     for (Pesanan pesanan : daftarPesanan)
    // }

    // Diskon
    // public double diskon(Pembayaran pembayaran) {
    //     if (pembayaran == QRIS) {
    //         return 0.05;
    //     } else if (totalHarga >= 200) {
    //         return 0.1;
    //     } else if (totalHarga >= 300) {
    //         return 0.15;
    //     } else {
    //         return 0.0;
    //     }
    // }

}