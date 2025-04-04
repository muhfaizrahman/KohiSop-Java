package mata_uang;

import java.util.Scanner;

public class MataUang {
    private static IMataUang mataUangDipilih;

    public static void seMataUang(IMataUang mataUang) {
        mataUangDipilih = mataUang;
    }

    public static IMataUang getMataUang() {
        return mataUangDipilih;
    }

    public static IMataUang pilihMataUang() {
        Scanner input = new Scanner(System.in);
        mataUangDipilih = null;
        
        while (mataUangDipilih == null) {
            System.out.println("Pilih mata uang pembayaran: \nUSD\nEUR\nMYR\nJPY");
            String pilih = input.next().toUpperCase();
            switch (pilih) {
                case "USD": mataUangDipilih = new USD(); break;
                case "EUR": mataUangDipilih = new EUR(); break;
                case "MYR": mataUangDipilih = new MYR(); break;
                case "JPY": mataUangDipilih = new JPY(); break;
                default:
                    System.out.println("Error: Mata uang tidak ditemukan. Coba lagi.");
                break;
            }
        }
        return mataUangDipilih;
    }
}