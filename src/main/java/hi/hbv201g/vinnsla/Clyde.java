package hi.hbv201g.vinnsla;

import hi.hbv201g.vidmot.Draugar;
import hi.hbv201g.vidmot.Pacman;

public class Clyde extends Draugar {
    public Clyde(int draugar, boolean elta, Pacman p, double[] a, double[] b, double[] home) {
        super(draugar, elta, p, a, b, home);
    }

    public double clyde(double[] a) {
        if (!getEtan()) {
            if (getElta()) {
                double[] stefna = getP().Hnit();
                double[] radius = new double[2];
                for (int i = 0; i < radius.length; i++) {
                    radius[i] = stefna[i] - a[i];
                }
                if (Math.pow(radius[0], 2) + Math.pow(radius[0], 2) <= 8) {
                    return ToHomeBaes(a);
                }
                return ToPac(a);
            } else {
                return ToHomeBaes(a);
            }


        } else {
            return home(a);
        }
    }
}
