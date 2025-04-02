package mata_uang;

public class USD implements IMataUang {
    public double konversiKeIDR(double nominal) {
        return nominal * 15;
    }
}
