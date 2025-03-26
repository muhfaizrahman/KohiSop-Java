package mata_uang;

public class JPY implements MataUang {
    public double konversiKeIDR(double nominal) {
        return nominal / 10;
    }
}
