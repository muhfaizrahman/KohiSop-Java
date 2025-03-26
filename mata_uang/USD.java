package mata_uang;

public class USD implements MataUang {
    public double konversiKeIDR(double nominal) {
        return nominal * 15;
    }
}
