package hi.hbv201g.vinnsla;

import hi.hbv201g.vidmot.Draugar;

public class Hreyfigeta {

    public int reknirit(double[] d, double[] stefna) {
        return (int) (Math.pow(d[0] - stefna[0], 2) + Math.pow(d[0] - stefna[0], 2));
    }

    public double[] piontOfColuslson(double[] a, int i) {
        if (i % 2 == 0) {
            if (i == 0) {
                a[1] += 1;
            } else {
                a[1] -= 1;
            }
        } else {
            if (i > 1) {
                a[0] += 1;
            } else {
                a[0] -= 1;
            }
        }
        return a;
    }



}
