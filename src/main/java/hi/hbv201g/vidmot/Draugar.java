package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.Hreyfigeta;
import hi.hbv201g.vinnsla.Stefna;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Draugar extends Circle implements Afarm {
    private int draugar;
    private Pacman p;
    private Draugar blinky;
    private final int OFFSET = 1;
    private boolean elta;
    private boolean hraedir = false;
    private boolean etan = false;
    private Hreyfigeta hreyfing;
    private Random random;
    private double maxLEND;
    private double[] homeBase;
    private final double[] HOME;


    public Draugar(int draugar, boolean elta, Pacman p, double[] a, double[] b, double[] home) {
        this.draugar = draugar;
        this.elta = elta;
        this.p = p;
        maxLEND = hreyfing.reknirit(a, b);
        HOME = home;
    }

    public void setBlinky(Draugar blinky) {
        this.blinky = blinky;
    }

    public Pacman getP() {
        return p;
    }

    public void setHomeBase(double[] homeBase) {
        this.homeBase = homeBase;
    }

    public void setHredir(boolean hraedir) {
        setRotate(turnAround());
        this.hraedir = hraedir;
    }

    public void setElta(boolean elta) {
        setRotate(turnAround());
        this.elta = elta;
    }

    public void setEtan(boolean etan) {
        if (hraedir) {
            hraedir = false;
        }
        this.etan = etan;
    }

    private double turnAround() {
        return (getRotate() + 180) % 360;
    }

    private double blinky(double[] a) {
        if (!etan) {
            if(elta) {
                return ToPac(a);
            }else {
                return ToHomeBaes(a);
            }

        } else {
            return home(a);
        }
    }

    private double inky(double[] a) {
        if (!etan) {
            if(elta) {
                double[] stefna = p.getHint();
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
                double[] d = blinky.getHint();
                double[] mismunnur = new double[2];
                for (int i = 0; i < mismunnur.length; i++) {
                    mismunnur[i] = stefna[i] - d[i];
                }
                for (int i = 0; i < stefna.length; i++) {
                    stefna[i] -= mismunnur[i];
                }
                return hreyfing.reknirit(a, stefna);
            }else {
                return ToHomeBaes(a);
            }

        }else{
            return home(a);
        }
    }

    private double pinky(double[] a){
        if(!etan) {
            double[] stefna = p.getHint();
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
        }else {
            return home(a);
        }
    }

    private double clyde(double[] a) {
        if (!etan) {
            double[] stefna = p.getHint();
            double[] radius = new double[2];
            for (int i = 0; i < radius.length; i++) {
                radius[i] = stefna[i] - a[i];
            }
            if (Math.pow(radius[0], 2) + Math.pow(radius[0], 2) <= 8) {
                return ToHomeBaes(a);
            }
            return ToPac(a);
        }else {
            return home(a);
        }
    }

    private double ToPac(double[] a){
        return hreyfing.reknirit(a, p.getHint());
    }

    private double ToHomeBaes(double [] a){
        return hreyfing.reknirit(a,homeBase);
    }

    private double home(double[] a) {
        return hreyfing.reknirit(a, HOME);
    }

    public double[] getHint() {
        double[] a = new double[2];
        a[0] = getCenterX();
        a[1] = getCenterY();
        return getHint();
    }

    private double lend(int a, double[] b) {
        switch (a) {
            case 0:
                return blinky(b);

            case 1:
                return inky(b);

            case 2:
                return pinky(b);

            case 3:
                return clyde(b);
        }
        return 0;
    }

    private void direson() {
        setCenterX(getCenterX() + Math.cos(Math.toRadians(getRotate())) * OFFSET);
        setCenterY(getCenterY() + Math.sin(Math.toRadians(getRotate())) * OFFSET);
    }

    @Override
    public void afarm() {
        double bakvid = turnAround();
        double minLend = maxLEND;
        double lend = minLend;

        if (hraedir) {
            setRotate(random.nextInt(4));
            while (bakvid == getRotate()) {
                setRotate(random.nextInt(4));
            }
            direson();
        } else {
            for (int i = 0; i < 4; i++) {
                double att = (90 + (90 * i)) % 360;

                if (bakvid != att) {
                    double[] maeliStadur = getHint();
                    maeliStadur = hreyfing.piontOfColuslson(maeliStadur, i);
                    lend = lend(draugar, maeliStadur);

                    if (lend < minLend) {
                        minLend = lend;
                        direson();
                    }
                }
            }
        }
    }
}

