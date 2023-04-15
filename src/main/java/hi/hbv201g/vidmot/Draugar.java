package hi.hbv201g.vidmot;

import javafx.scene.shape.Circle;

import java.util.Random;

public abstract class Draugar extends Circle implements Afarm, Hnit {
    protected Pacman p;
    protected boolean elta = false;
    protected boolean etan = false;
    protected boolean hraedir = false;
    private final int OFFSET = 1;
    private Random random;
    private final double MAX_LEND;
    private final double[] HOME;

    public abstract double drauaReikniritd(double[] a);

    public Draugar(Pacman p, double[] a, double[] b, double[] home) {
        this.p = p;
        MAX_LEND = reknirit(a, b);
        HOME = home;
        FXMLLoder loader = new FXMLLoder(this,"Draugar.fxml");
    }

    /**
     * stilir hvor daugar eru hræædir við pacman það er að seyja
     * hvor pack mann getur étið þá eða ekki, þetta hefur sá áfirf
     * að draugnir færst handhófslega
     *
     * @param hraedir er boolean breyta.
     */
    public void setHredir(boolean hraedir) {
        setRotate(turnAround());
        this.hraedir = hraedir;
    }

    /**
     * Hér er still hvor draugarning eru að elda pacman eða
     * stefna heim með því að taka inn boolean beytu
     *
     * @param elta er boolean breyta
     */
    public void setElta(boolean elta) {
        setRotate(turnAround());
        this.elta = elta;
    }

    /**
     * aðferinn stillir hvort draugaring eru étir eða ekki
     * of svo er þá fara þeir aftur heim.
     *
     * @param etan boolean breyta
     */
    public void setEtan(boolean etan) {
        if (hraedir) {
            hraedir = false;
        }
        this.etan = etan;
    }

    /**
     * þess að ferð skilar stefnuni sem er beynt fyrir aftan
     * draugin, það er að seyja ef hann er að fara upp þá
     * skilar það niður.
     *
     * @return sikar gáðuni sem er firir aftan
     */
    private double turnAround() {
        return (getRotate() + 180) % 360;
    }

    public double ToPac(double[] a) {
        return reknirit(a, p.Hnit());
    }

    public double ToHomeBaes(double[] a, double[] homeBase) {
        return reknirit(a, homeBase);
    }

    public double home(double[] a) {
        return reknirit(a, HOME);
    }

    public double[] Hnit() {
        double[] a = new double[2];
        a[0] = getCenterX();
        a[1] = getCenterY();
        return a;
    }

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

    private void direson(PacmanMaze sc) {
        double a = getCenterX() + Math.cos(Math.toRadians(getRotate())) * OFFSET;
        double b = getCenterY() + Math.sin(Math.toRadians(getRotate())) * OFFSET;
        sc.fearDrauga(a, b, this);
    }

    @Override
    public void afarm(boolean[] path, PacmanMaze sc) {
        double bakvid = turnAround();
        double minLend = MAX_LEND;
        double lend = minLend;

        if (hraedir) {
            setRotate(random.nextInt(4));
            while (bakvid == getRotate()) {
                setRotate(random.nextInt(4));
                for (int i = 0; i < path.length; i++) {
                    if (getRotate() == (90 + (90 * i)) % 360 && !path[i]) {
                        setRotate(bakvid);
                        break;
                    }
                }
            }
            direson(sc);
        } else {
            for (int i = 0; i < 4; i++) {
                double att = (90 + (90 * i)) % 360;

                if (bakvid != att && path[i]) {
                    double[] maeliStadur = Hnit();
                    maeliStadur = piontOfColuslson(maeliStadur, i);
                    lend = drauaReikniritd(maeliStadur);

                    if (lend < minLend) {
                        minLend = lend;
                        setRotate(att);
                    }
                }
            }
            direson(sc);
        }
    }
}

