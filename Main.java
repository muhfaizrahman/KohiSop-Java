import java.util.Scanner;

import mata_uang.EUR;
import mata_uang.JPY;
import mata_uang.MYR;
import mata_uang.MataUang;
import mata_uang.USD;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String pilihan = input.nextLine().toUpperCase();
        MataUang mataUang = null;

        while (mataUang == null) {
            switch (pilihan) {
                case "USD": mataUang = new USD(); break;
                case "JPY": mataUang = new JPY(); break;
                case "MYR": mataUang = new MYR(); break;
                case "EUR": mataUang = new EUR(); break;
                default: System.out.println("Mata uang tidak valid, silakan coba lagi.");
            }
        }

        double nominal = input.nextDouble();
        System.out.println(mataUang.konversiKeIDR(nominal));
    }
}
