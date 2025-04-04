package channel_pembayaran;

import java.util.Scanner;

import mata_uang.IMataUang;
import mata_uang.MataUang;
import perhitungan.HitungHarga;
import perhitungan.Pajak;

public class PembayaranSaldo extends Pembayaran {
    protected Saldo saldo;

    PembayaranSaldo(double diskon, int biayaAdmin) {
        super(diskon, biayaAdmin);
        this.saldo = new Saldo();
    }

    @Override
    public void bayar(Scanner input) {
        System.out.println("Pembayaran " + this.getClass().getSimpleName());

        IMataUang mataUang = MataUang.getMataUang();
        double hargaSebelumDiskon = HitungHarga.hitungTotalHarga();
        double totalHargaIDR = (hargaSebelumDiskon * (1 - diskon)) + biayaAdmin + Pajak.getPajakTotal();
        double totalHarga = mataUang.konversiDariIDR(totalHargaIDR);
        
        // Bayar
        while (true) {
            System.out.printf("Total tagihan adalah : %.2f %s\n", totalHarga, mataUang.getClass().getSimpleName());
            
            if (saldo.getSaldo() >= totalHargaIDR) {
                saldo.setSaldo(-totalHargaIDR);
                System.out.println("Pembayaran dengan " + this.getClass().getSimpleName() + " berhasil.");
                System.out.printf("Saldo anda sekarang adalah : %.2f IDR // %.2f %s\n", saldo.getSaldo(), mataUang.konversiDariIDR(saldo.getSaldo()), mataUang.getClass().getSimpleName());
                System.out.println("Berikut adalah kuitansinya: ");
                break;
            } else {
                System.out.println("Saldo tidak mencukupi. Silakan top up terlebih dahulu.");
                System.out.println("Masukkan nominal untuk top up saldo: ");
                saldo.setSaldo(input.nextDouble());
                System.out.println("Top up saldo berhasil.");
                System.out.printf("Saldo anda sekarang adalah : %.2f IDR // %.2f %s\n", saldo.getSaldo(), mataUang.konversiDariIDR(saldo.getSaldo()), mataUang.getClass().getSimpleName());
                continue;
            }
        }

    }
}
