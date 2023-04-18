package hi.hbv201g.vidmot;

public class Clyde extends Draugar {
    private final int[] HOME_BASE;

    public Clyde(Pacman p, int[] a, int[] b, int[] home, int[] homeBase) {
        super(p, a, b, home);
        HOME_BASE = homeBase;
    }

    public double drauaReikniritd(int[] a) {
        if (!etan) {
            if (elta) {
                int[] stefna = p.Hnit();
                int[] stadSeting =this.Hnit();
                int[] radius = new int[2];
                for (int i = 0; i < radius.length; i++) {
                    radius[i] = stefna[i] - stadSeting[i];
                    if(radius[i]<0){
                        radius[i]*=-1;
                    }
                }
                if (Math.pow(radius[0], 2) + Math.pow(radius[1], 2) <= 8) {
                    return ToHomeBaes(a, HOME_BASE);

                } else if (radius[0] == 0 && radius[0] + Math.pow(radius[1], 2) <= 8) {
                    return ToHomeBaes(a, HOME_BASE);

                } else if (radius[1] == 0 && radius[1] + Math.pow(radius[0], 2) <= 8) {
                    return ToHomeBaes(a, HOME_BASE);
                }

                return ToPac(a);
            } else {
                return ToHomeBaes(a, HOME_BASE);
            }


        } else {
            return home(a);
        }
    }
}
