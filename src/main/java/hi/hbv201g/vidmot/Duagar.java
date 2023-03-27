package hi.hbv201g.vidmot;

import hi.hbv201g.vinsla.Hreifigeta;
import javafx.scene.shape.Circle;

public class Duagar extends Circle {
    private int daugir;

    public boolean elta;
    private boolean hraedir = false;
    private Hreifigeta hreing;


    public Duagar(int daugir, boolean elta) {
        this.daugir = daugir;
        this.elta = elta;
    }

    public void setHredir(boolean hraedir) {
        this.hraedir = hraedir;
    }

    public void setElta(boolean elta) {
        this.elta = elta;
    }

    private double inky(Pacman p) {
        return hreing.reknirit(getHint(), p.getHint());
    }

    private double blinky(Pacman p, Duagar inky) {
        double[] stfna = p.getHint();
        double att = p.getStefna();
        if (att == 0) {
            stfna[1] += 2;
        } else if (att == 1) {
            stfna[0] += 2;
        } else if (att == 2) {
            stfna[1] -= 2;
        } else {
            stfna[0] -= 2;
        }
        double[] d = inky.getHint();
        double[] missmunnur = new double[2];
        for (int i = 0; i < missmunnur.length; i++) {
            missmunnur[i] = stfna[i] - d[i];
        }
        for (int i = 0; i < stfna.length; i++) {
            stfna[i] -= missmunnur[i];
        }
        return hreing.reknirit(getHint(), p.getHint());
    }

    private double pinky(Pacman p) {
        double[] stfna = p.getHint();
        double att = p.getStefna();
        if (att == 0) {
            stfna[1] += 4;
        } else if (att == 4) {
            stfna[0] += 4;
        } else if (att == 4) {
            stfna[1] -= 4;
        } else {
            stfna[0] -= 4;
        }
        return hreing.reknirit(getHint(), p.getHint());
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
        return hreing.reknirit(getHint(), p.getHint());
    }

    public double[] getHint() {
        double[] a = new double[2];
        a[0] = getCenterX();
        a[1] = getCenterY();
        return getHint();
    }


}
