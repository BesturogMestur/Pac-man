package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.Hreyfigeta;
import javafx.scene.shape.Circle;

public class Draugar extends Circle {
    private int draugar;

    public boolean elta;
    private boolean hraedir = false;
    private Hreyfigeta hreyfing;


    public Draugar(int draugar, boolean elta) {
        this.draugar = draugar;
        this.elta = elta;
    }

    public void setHredir(boolean hraedir) {
        this.hraedir = hraedir;
    }

    public void setElta(boolean elta) {
        this.elta = elta;
    }

    private double inky(Pacman p) {
        return hreyfing.reknirit(getHint(), p.getHint());
    }

    private double blinky(Pacman p, Draugar inky) {
        double[] stefna = p.getHint();
        double att = p.getStefna();
        if (att == 0) {
            stefna[1] += 2;
        } else if (att == 1) {
            stefna[0] += 2;
        } else if (att == 2) {
            stefna[1] -= 2;
        } else {
            stefna[0] -= 2;
        }
        double[] d = inky.getHint();
        double[] mismunnur = new double[2];
        for (int i = 0; i < mismunnur.length; i++) {
            mismunnur[i] = stefna[i] - d[i];
        }
        for (int i = 0; i < stefna.length; i++) {
            stefna[i] -= mismunnur[i];
        }
        return hreyfing.reknirit(getHint(), p.getHint());
    }

    private double pinky(Pacman p) {
        double[] stefna = p.getHint();
        double att = p.getStefna();
        if (att == 0) {
            stefna[1] += 4;
        } else if (att == 1) {
            stefna[0] += 4;
        } else if (att == 2) {
            stefna[1] -= 4;
        } else {
            stefna[0] -= 4;
        }
        return hreyfing.reknirit(getHint(), p.getHint());
    }

    private double clyde(Pacman p) {
        double[] a = getHint();
        double[] stefna = p.getHint();
        double[] radius = new double[2];
        for (int i = 0; i < radius.length; i++) {
            radius[i] = stefna[i] - a[i];
        }
        if (Math.pow(radius[0], 2) + Math.pow(radius[0], 2) == 8) {
            return 0; //munn gera flýja sena
        }
        return hreyfing.reknirit(getHint(), p.getHint());
    }

    public double[] getHint() {
        double[] a = new double[2];
        a[0] = getCenterX();
        a[1] = getCenterY();
        return getHint();
    }


}
