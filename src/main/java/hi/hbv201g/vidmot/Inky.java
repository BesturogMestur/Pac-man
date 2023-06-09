package hi.hbv201g.vidmot;

public class Inky extends Draugar {
    private final int[] HOME_BASE;
    private Draugar blinky;

    public Inky(Pacman p, int[] a, int[] b, int[] home, int[] homeBase, Draugar blinky) {
        super(p, a, b, home);
        this.blinky = blinky;
        HOME_BASE = homeBase;

    }

    public double drauaReikniritd(int[] a, PacmanMaze sc) {
        if (!etan) {
            if (elta) {
                int[] stefna = p.hnit(sc);
                double att = p.getStefna() / 90;
                if (att == Stefna.UPP.getGradur()) {
                    stefna[1] -= 2;
                } else if (att == Stefna.VINSTRI.getGradur()) {
                    stefna[0] -= 2;
                } else if (att == Stefna.NIDUR.getGradur()) {
                    stefna[1] += 2;
                } else {
                    stefna[0] += 2;
                }
                int[] d = blinky.hnit(sc);
                double[] mismunnur = new double[2];
                for (int i = 0; i < mismunnur.length; i++) {
                    mismunnur[i] = stefna[i] - d[i];
                }
                for (int i = 0; i < stefna.length; i++) {
                    stefna[i] -= mismunnur[i];
                }
                return reknirit(a, stefna);
            } else {
                return ToHomeBaes(a, HOME_BASE);
            }

        } else {
            return home(a);
        }
    }
}
