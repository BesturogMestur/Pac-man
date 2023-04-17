package hi.hbv201g.vidmot;

public class Clyde extends Draugar {
    private final int[] HOME_BASE;

    public Clyde(Pacman p, int[] a, int[] b, int[] home, int[] homeBase) {
        super(p, a, b, home);
        HOME_BASE = homeBase;
    }

    public double drauaReikniritd(int[] a, PacmanMaze sc) {
        if (!etan) {
            if (elta) {
                int[] stefna = p.Hnit(sc);
                int[] radius = new int[2];
                for (int i = 0; i < radius.length; i++) {
                    radius[i] = stefna[i] - a[i];
                }
                if (Math.pow(radius[0], 2) + Math.pow(radius[0], 2) <= 8) {
                    return ToHomeBaes(a, HOME_BASE);
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
