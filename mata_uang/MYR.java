package mata_uang;

public class MYR implements MataUang {
    public double konversiKeIDR(double nominal) {
        return nominal * 4;
    }
}
