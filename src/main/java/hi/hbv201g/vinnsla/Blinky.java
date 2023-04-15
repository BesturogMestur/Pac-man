package hi.hbv201g.vinnsla;

import hi.hbv201g.vidmot.Draugar;
import hi.hbv201g.vidmot.FXMLLoder;
import hi.hbv201g.vidmot.Pacman;

public class Blinky extends Draugar {
    private final double[] HOME_BASE;
    public Blinky(Pacman p, double[] a, double[] b, double[] home, double[] homeBase) {
        super(p, a, b, home);
        HOME_BASE=homeBase;
    }
    public double drauaReikniritd (double[] a) {
        if (!etan) {
            if (elta) {
                return ToPac(a);
            } else {
                return ToHomeBaes(a,HOME_BASE);
            }

        } else {
            return home(a);
        }
    }
}
