package hi.hbv201g.vinnsla;

import hi.hbv201g.vidmot.Draugar;
import hi.hbv201g.vidmot.Pacman;

public class Pinky extends Draugar {
    private final double[] HOME_BASE;
    public Pinky(int draugar, boolean elta, Pacman p, double[] a, double[] b, double[] home, double[] homeBase) {
        super(draugar, elta, p, a, b, home);
        HOME_BASE=homeBase;
    }

    public double drauaReikniritd (double[] a) {
        if (!getEtan()) {
            if (getElta()) {
                double[] stefna = p.Hnit();
                double att = p.getStefna();
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
                return ToHomeBaes(a,HOME_BASE);
            }

        } else {
            return home(a);
        }
    }

}
