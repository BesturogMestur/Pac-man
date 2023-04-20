package hi.hbv201g.vidmot;

public class Blinky extends Draugar {
    private final int[] HOME_BASE;

    public Blinky(Pacman p, int[] a, int[] b, int[] home, int[] homeBase) {
        super(p, a, b, home);
        HOME_BASE = homeBase;
    }

    public double drauaReikniritd(int[] a, PacmanMaze sc) {
        if (!etan) {
            if (elta) {
                return ToPac(a,sc);
            } else {
                return ToHomeBaes(a, HOME_BASE);
            }

        } else {
            return home(a);
        }
    }
}
