package mata_uang;

public class JPY implements IMataUang {
    public double konversiKeIDR(double nominal) {
        return nominal / 10;
    }
}
