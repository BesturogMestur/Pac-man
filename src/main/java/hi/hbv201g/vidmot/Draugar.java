package hi.hbv201g.vidmot;

import javafx.scene.shape.Circle;

import java.util.Random;

public abstract class Draugar extends Circle implements Afarm, Hnit {
    protected Pacman p;
    protected boolean elta = false;
    protected boolean etan = false;
    protected boolean hraedir = false;
    private final int OFFSET = 1;
    private final double MAX_LEND;
    private final int[] HOME;

    public abstract double drauaReikniritd(int[] a, PacmanMaze sc);

    public Draugar(Pacman p, int[] a, int[] b, int[] home) {
        FXMLLoder loder = new FXMLLoder(this, "Draugar.fxml");
        this.p = p;
        MAX_LEND = reknirit(a, b);
        HOME = home;
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

    /**
     * hér er reikna frlæðina í pacman frá staðsetið dausin sem er fengin með
     * double fylki sem hfur x gildi og y gildi draugis og missmunnin í maze
     * klasanum
     *
     * @param a staðsetin draugsins
     * @param sc er maze sme druarinr er í
     * @return frlæðina í pac
     */
    public int ToPac(int[] a, PacmanMaze sc) {
        return reknirit(a, p.hnit(sc));
    }

    /**
     * Hér er reikan út fjarlæðin í hornið sem á hvrðið drugur hefur með
     * því að taka inn stað setinu drusin og serð setinu hornið sem
     * daurgurinn á.
     *
     * @param a        x, y stað setining á drauginum
     * @param homeBase x, y stað setining á horninu
     * @return frjarlæð í homeBase
     */
    public int ToHomeBaes(int[] a, int[] homeBase) {
        return reknirit(a, homeBase);
    }

    /**
     * hér er reikað frlæðia til draugabælið með því að vita staðsetingu
     * á drauginum.
     *
     * @param a er stað setingin á drauginum
     * @return frækaðin í drauga bælið
     */
    public int home(int[] a) {
        return reknirit(a, HOME);
    }

    /**
     * hér fáum við staðsetinu á drauginum
     *
     * @return filki sem inni heldur x og y hnit drausins
     */
    public int[] hnit(PacmanMaze sc) {
        int[] a = new int[2];
        a[0] = (int) ((getCenterX() - sc.MID_VEGG_X) / sc.BREID);
        a[1] = (int) ((getCenterY() - sc.MID_VEGG_Y) / sc.BREID);
        return a;
    }

    /**
     * hér er reiknitritið sem fem reiknar út frlæðinar á milli tvegja
     * staðsetinat og sem eru gefnar með fylkum.
     *
     * @param d
     * @param stefna
     * @return
     */
    public int reknirit(int[] d, int[] stefna) {
        double x = d[0] - stefna[0];
        double y = (d[1] - stefna[1]);
        if (x != 0) {
            if (x < 0) {
                x *= -1;
            }
            x = Math.pow(x, 2);
        }
        if (y != 0) {
            if (y < 0) {
                y *= -1;
            }
            y = Math.pow(y, 2);
        }
        int sum = (int) (x + y);
        return sum;
    }

    public int[] piontOfColuslson(int[] a, int i, PacmanMaze sc) {
        if (i % 2 == 0) {
            if (i == 0) {
                a[1] -= sc.MID_VEGG_Y;
            } else {
                a[1] += sc.MID_VEGG_Y;
            }
        } else {
            if (i > 1) {
                a[0] -= sc.MID_VEGG_X;
            } else {
                a[0] += sc.MID_VEGG_X;
            }
        }
        return a;
    }

    private void direson(PacmanMaze sc) {
        if (getRotate() == 90) {
            setCenterY(getCenterY() - sc.MID_VEGG_Y);
        } else if (getRotate() == 180) {
            setCenterX(getCenterX() - sc.MID_VEGG_X);
        } else if (getRotate() == 270) {
            setCenterY(getCenterY() + sc.MID_VEGG_Y);
        } else {
            setCenterX(getCenterX() + sc.MID_VEGG_X);
        }
    }

    @Override
    public void afarm(boolean[] path, PacmanMaze sc, double s) {
        double bakvid = turnAround();
        double minLend = MAX_LEND;
        double lend;
        Random random = new Random();

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
                    int[] maeliStadur = hnit(sc);
                    maeliStadur = piontOfColuslson(maeliStadur, i, sc);
                    lend = drauaReikniritd(maeliStadur, sc);

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

