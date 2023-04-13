package hi.hbv201g.vinnsla;

import hi.hbv201g.vidmot.Draugar;
import hi.hbv201g.vidmot.Pacman;

public class Inky extends Draugar {
    private final double[] HOME_BASE;
    private Blinky blinky;

    public Inky(Pacman p, double[] a, double[] b, double[] home, double[] homeBase, Blinky blinky) {
        super(p, a, b, home);
        this.blinky = blinky;
        HOME_BASE = homeBase;

    }

    public double drauaReikniritd(double[] a) {
        if (!etan) {
            if (elta) {
                double[] stefna = p.Hnit();
                double att = p.getStefna() / 90;
                if (att == Stefna.UPP.getGradur()) {
                    stefna[1] += 2;
                } else if (att == Stefna.VINSTRI.getGradur()) {
                    stefna[0] -= 2;
                } else if (att == Stefna.NIDUR.getGradur()) {
                    stefna[1] -= 2;
                } else {
                    stefna[0] += 2;
                }
                double[] d = blinky.Hnit();
                double[] mismunnur = new double[2];
                for (int i = 0; i < mismunnur.length; i++) {
                    mismunnur[i] = stefna[i] - d[i];
                }
                for (int i = 0; i < stefna.length; i++) {
                    stefna[i] -= mismunnur[i];
                }
                return reknirit(a, stefna);
            } else {
                return ToHomeBaes(a,HOME_BASE);
            }

        } else {
            return home(a);
        }
    }
}
