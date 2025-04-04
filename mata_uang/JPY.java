package mata_uang;

public class JPY implements IMataUang {
    private double kurs = 10.0;
    public double konversiDariIDR(double nominal) {
        return nominal * kurs;
    }
}
