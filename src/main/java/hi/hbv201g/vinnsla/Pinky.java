package hi.hbv201g.vinnsla;

import hi.hbv201g.vidmot.Draugar;
import hi.hbv201g.vidmot.Pacman;

public class Pinky extends Draugar {
    public Pinky(int draugar, boolean elta, Pacman p, double[] a, double[] b, double[] home) {
        super(draugar, elta, p, a, b, home);
    }

    public double pinky(double[] a) {
        if (!getEtan()) {
            if (getElta()) {
                double[] stefna = getP().Hnit();
                double att = getP().getStefna();
                if (att == Stefna.UPP.getGradur()) {
                    stefna[1] += 4;
                } else if (att == Stefna.VINSTRI.getGradur()) {
                    stefna[0] -= 4;
                } else if (att == Stefna.NIDUR.getGradur()) {
                    stefna[1] -= 4;
                } else {
                    stefna[0] += 4;
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
