package pemesanan;

public class Makanan extends Menu {
    String[] kode = {"M1", "M2", "M3", "M4", "S1", "S2", "S3", "S4"};
    String[] nama = {
        "Petemania Pizza", 
        "Mie Rebus Super Mario", 
        "Ayam Bakar Goreng Rebus Spesial", 
        "Soto Kambing Iga Guling", 
        "Singkong Bakar A La Carte", 
        "Ubi Cilembu Bakar Arang", 
        "Tempe Mendoan", 
        "Tahu Bakso Extra Telur"
    };
    int[] harga = {112, 35, 72, 124, 37, 58, 18, 28};

    @Override
    public void display() {
        for (int i = 0; i < kode.length; i++) {
            System.out.printf("| %-5s | %-40s | %-10d |\n", kode[i], nama[i], harga[i]);
        }
    }
}
