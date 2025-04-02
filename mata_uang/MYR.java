package mata_uang;

public class MYR implements IMataUang {
    public double konversiKeIDR(double nominal) {
        return nominal * 4;
    }
}
