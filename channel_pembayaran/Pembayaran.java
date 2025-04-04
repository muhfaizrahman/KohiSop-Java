package channel_pembayaran;

public abstract class Pembayaran {
    protected double diskon;
    protected double biayaAdmin;

    Pembayaran(double diskon, double biayaAdmin) {
        this.diskon = diskon;
        this.biayaAdmin = biayaAdmin;
    }

    public abstract void bayar(java.util.Scanner input);

    public double getDiskon() {
        return diskon;
    }

    public double getBiayaAdmin() {
        return biayaAdmin;
    }

    }
