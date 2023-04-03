package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.Hreyfigeta;
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
    public Draugar getBlinky(){
        return blinky;
    }

    public Pacman getP() {
        return p;
    }

    public Hreyfigeta getHreyfing() {
        return hreyfing;
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
    public boolean getElta(){
        return elta;
    }

    public void setEtan(boolean etan) {
        if (hraedir) {
            hraedir = false;
        }
        this.etan = etan;
    }

    public boolean getEtan(){
        return etan;
    }

    private double turnAround() {
        return (getRotate() + 180) % 360;
    }

    public double ToPac(double[] a) {
        return hreyfing.reknirit(a, p.getHint());
    }

    public double ToHomeBaes(double[] a) {
        return hreyfing.reknirit(a, homeBase);
    }

    public double home(double[] a) {
        return hreyfing.reknirit(a, HOME);
    }

    public double[] getHint() {
        double[] a = new double[2];
        a[0] = getCenterX();
        a[1] = getCenterY();
        return getHint();
    }

    private void direson() {
        setCenterX(getCenterX() + Math.cos(Math.toRadians(getRotate())) * OFFSET);
        setCenterY(getCenterY() + Math.sin(Math.toRadians(getRotate())) * OFFSET);
    }

    @Override
    public void afarm(boolean[] path) {
        double bakvid = turnAround();
        double minLend = maxLEND;
        double lend = minLend;

        if (hraedir) {
            setRotate(random.nextInt(4));
            while (bakvid == getRotate()) {
                setRotate(random.nextInt(4));
                for(int i=0; i< path.length;i++){
                    if(getRotate()==(90+(90*i))%360&&!path[i]){
                        setRotate(bakvid);
                        break;
                    }
                }
            }
            direson();
        } else {
            for (int i = 0; i < 4; i++) {
                double att = (90 + (90 * i)) % 360;

                if (bakvid != att && path[i]) {
                    double[] maeliStadur = getHint();
                    maeliStadur = hreyfing.piontOfColuslson(maeliStadur, i);
                    lend = hreyfing.lend(draugar, maeliStadur);

                    if (lend < minLend) {
                        minLend = lend;
                        direson();
                    }
                }
            }
        }
    }
}

