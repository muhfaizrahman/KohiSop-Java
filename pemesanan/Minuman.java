package pemesanan;

public class Minuman extends Menu {
    String[] kode = {"A1", "A2", "E1", "E2", "E3", "E4", "E5", "B1", "B2", "B3"};
    String[] nama = {
        "Caffe Latte", 
        "Cappuccino", 
        "Caffe Americano", 
        "Caffe Mocha", 
        "Caramel Macchiato", 
        "Asian Dolce Latte", 
        "Double Shots Iced Shaken Espresso", 
        "Freshly Brewed Coffee", 
        "Vanilla Sweet Cream Cold Brew", 
        "Cold Brew"
    };
    int[] harga = {46, 46, 37, 55, 59, 55, 50, 23, 50, 44};

    @Override
    public void display() {
        for (int i = 0; i < kode.length; i++) {
            System.out.printf("| %-5s | %-40s | %-10d |\n", kode[i], nama[i], harga[i]);
        }
    }
}
