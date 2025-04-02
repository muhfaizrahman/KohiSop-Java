package mata_uang;

public class EUR implements IMataUang {
    public double konversiKeIDR(double nominal) {
        return nominal * 14;
    }
}
