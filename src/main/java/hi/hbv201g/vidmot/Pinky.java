package hi.hbv201g.vidmot;

public class Pinky extends Draugar {
    private final int[] HOME_BASE;

    public Pinky(Pacman p, int[] a, int[] b, int[] home, int[] homeBase) {
        super(p, a, b, home);
        HOME_BASE = homeBase;
    }

    public double drauaReikniritd(int[] a, PacmanMaze sc) {
        if (!etan) {
            if (elta) {
                int[] stefna = p.Hnit(sc);
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
                return ToPac(a, sc);
            } else {
                return ToHomeBaes(a, HOME_BASE);
            }

        } else {
            return home(a);
        }
    }

}
