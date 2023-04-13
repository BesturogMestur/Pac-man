package hi.hbv201g.vinnsla;

import hi.hbv201g.vidmot.Draugar;
import hi.hbv201g.vidmot.Pacman;

public class Clyde extends Draugar {
    private final double[] HOME_BASE;
    public Clyde(Pacman p, double[] a, double[] b, double[] home, double[] homeBase) {
        super(p, a, b, home);
        HOME_BASE=homeBase;
    }

    public double drauaReikniritd(double[] a) {
        if (!etan) {
            if (elta) {
                double[] stefna = p.Hnit();
                double[] radius = new double[2];
                for (int i = 0; i < radius.length; i++) {
                    radius[i] = stefna[i] - a[i];
                }
                if (Math.pow(radius[0], 2) + Math.pow(radius[0], 2) <= 8) {
                    return ToHomeBaes(a,HOME_BASE);
                }
                return ToPac(a);
            } else {
                return ToHomeBaes(a,HOME_BASE);
            }


        } else {
            return home(a);
        }
    }
}
