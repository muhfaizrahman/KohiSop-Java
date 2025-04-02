package pemesanan;

public abstract class Menu {
    public abstract void display();

    static Makanan makanan = new Makanan();
    static Minuman minuman = new Minuman();
    
    public static void displayMenu() {
        System.out.println("|-------|------------------------------------------|------------|");
        System.out.printf("| %-5s | %-40s | %-10s |\n", "Kode", "Menu Minuman", "Harga (Rp)");
        System.out.println("|-------|------------------------------------------|------------|");
        makanan.display();
        System.out.println("|-------|------------------------------------------|------------|");
        System.out.printf("| %-5s | %-40s | %-10s |\n", "Kode", "Menu Makanan", "Harga (Rp)");
        System.out.println("|-------|------------------------------------------|------------|");
        minuman.display();
        System.out.println("|-------|------------------------------------------|------------|");
    }
    
}