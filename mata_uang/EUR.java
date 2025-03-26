package mata_uang;

public class EUR implements MataUang {
    public double konversiKeIDR(double nominal) {
        return nominal * 14;
    }
}
