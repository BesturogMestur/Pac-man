package hi.hbv201g.vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PacmanMaze extends Pane {

    private boolean[][] maze = {
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, true, true, true, true, true, true, true, true, true, true, true, true, false},
            {false, true, false, false, false, true, false, false, false, true, false, false, true, false},
            {false, true, false, true, true, true, true, true, true, true, true, true, true, false},
            {false, true, false, true, false, true, false, false, false, false, true, false, true, false},
            {false, true, false, true, false, true, false, true, true, false, true, false, true, false},
            {false, true, true, true, false, true, false, true, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, true, true, false, true, false, true, false},
            {false, true, false, true, false, true, false, false, false, false, true, false, true, false},
            {false, true, false, true, true, true, true, true, true, true, true, true, true, false},
            {false, true, false, false, false, true, false, false, false, true, false, false, true, false},
            {false, true, true, true, true, true, true, true, true, true, true, true, true, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false}};
    private final int MAX_ROW=14;
    private final int MAX_COL=13;
    private final int[] HOME = {6, 5};
    private final int[] UPPHAFS_PUNKTUR = {0, 0};
    private final int[] MESTA_LEGNT_FRA_UPPHAF = {MAX_ROW,MAX_COL};
    private final int[] BLINKY_HOME = {MAX_ROW, 0};
    private final int[] CLYDE_HOME = {0, MAX_COL};
    protected final double BREID=46.1538;
    protected final double HIGTH =28.5714;
    protected final double BERID_VEGGS=47.0;
    protected final double HAED_VEEGS=31.0;
    protected final double MID_VEGG_X=BERID_VEGGS/2;
    protected final double MID_VEGG_Y=HAED_VEEGS/2;
    private final int[] TIMAR = {10, 8, 10, 2};
    private int havdaTimi = 0;
    private int timi;
    protected double stfna;
    private Pacman fxPacman;
    private Draugar blinky;
    private Draugar inky;
    private Draugar pinky;
    private Draugar clyde;
    private ObservableList<Pellets> pellets = FXCollections.observableArrayList();

    public PacmanMaze() {
        FXMLLoder loader = new FXMLLoder(this, "PacmanMaze.fxml");
        setMaze();
        fxPacman = new Pacman();
        setPecman(6,10);
        stfna=0.0;
    }

    private void setMaze() {
        for(int j=0;j<MAX_ROW;j++){
            for (int i = 0; i<MAX_COL;i++){
                if(!maze[i][j]){
                    Veggur v = new Veggur();
                    getChildren().add(v);

                    v.setWidth(BERID_VEGGS);
                    v.setHeight(HAED_VEEGS);

                    v.setX(BREID*i);
                    v.setY(HIGTH*j);
                }
            }
        }
    }

    public void nyrLeikur() {
        pellets.removeAll();
        getChildren().removeAll();

        //setPecman(6, 10);
        timi = TIMAR[havdaTimi];
        setDraugar();
        setPellets();

    }

    private void setPecman(int x, int y) {
        getChildren().add(fxPacman);
        fxPacman.setCenterX((BREID*x)+MID_VEGG_X);
        fxPacman.setCenterY((HIGTH*y)+MID_VEGG_Y);
        System.out.println((fxPacman.getCenterY()-MID_VEGG_Y)/HIGTH);
    }

    private void setDraugar() {
        blinky = new Blinky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, BLINKY_HOME);
        blinky.getStyleClass().add("redghost.gif");
        blinky.setFill(Color.rgb(255,0,0));
        getChildren().add(blinky);
        blinky.setCenterX((BREID*1)+MID_VEGG_X);
        blinky.setCenterY((HIGTH*1)+MID_VEGG_Y);

        inky = new Inky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, MESTA_LEGNT_FRA_UPPHAF, blinky);
        inky.getStyleClass().add("cyan.gif");
        pinky = new Pinky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, UPPHAFS_PUNKTUR);
        pinky.getStyleClass().add("pink.gif");
        clyde = new Clyde(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, CLYDE_HOME);
        clyde.getStyleClass().add("yellowghost.gif");

    }

    public void setPellets() {
        for (int i = 1; i < MAX_ROW - 1; i++) {
            for (int j = 1; j < MAX_COL - 1; j++) {
                if (!((j == 5 || j == 6 || j == 7) && (i == 7 || i == 8))) {
                    if (maze[j][i]) {
                        Pellets p = new Pellets();
                        pellets.add(p);
                        p.setCenterX((BREID*j)+MID_VEGG_X);
                        p.setCenterY((HIGTH*i)+MID_VEGG_Y);
                        getChildren().add(p);

                    }
                }
            }
        }
        System.out.println(pellets.size());
    }

    /**
     * þesso aferð tekur in kommu tölu og stillir síðan stfnu þess á botaum.
     *
     * @param d Kommu tala
     */
    public void setStefna(Double d) {
        fxPacman.setRotate(d);
        stfna = d;
        System.out.println(fxPacman.getRotate());
    }

    public void pacmanAfram() {
        fxPacman.afarm(walls(fxPacman.hnit(this)), this , stfna);
    }



    public void aframDraugar(PacmanController sc) {
        aframDurgar(blinky, sc);
        aframDurgar(inky, sc);
        aframDurgar(pinky, sc);
        aframDurgar(clyde, sc);
        if (timi <= 0) {
            uppfraeraTima();
        }
    }

    private void aframDurgar(Draugar d, PacmanController sc) {
        int[] a = d.hnit(this);

        if (timi <= 0) {
            if (d.elta) {
                d.setElta(false);
            } else {
                d.setElta(true);
            }
        }
        if (a[0] == 6 && a[1] == 5) {
            d.setEtan(false);
            d.setRotate(90);
        }



        d.afarm(walls(d.hnit(this)), this, stfna);
        athugaPacman(d,sc);
    }


    private boolean[] walls(int[] a) {
        boolean[] walls = new boolean[4];

        for (int i = 0; i < walls.length; i++) {
            if (i % 2 == 0) {
                if (i == 0) {
                    walls[i] = maze[a[0]][a[1] - 1];
                } else {
                    walls[i] = maze[a[0]][a[1] + 1];
                }

            } else {
                if (i == 1) {
                    walls[i] = maze[a[0] - 1][a[1]];
                } else {
                    walls[i] = maze[a[0] + 1][a[1]];
                }
            }
        }
        return walls;

    }

    private void athugaPacman(Draugar d, PacmanController sc) {
        if (d.getBoundsInParent().intersects(fxPacman.getBoundsInParent())) {
            if (!d.hraedir && !d.etan) {
                sc.leikLokid();
                sc.showAlertDialog();
            } else if (d.hraedir) {
                d.setEtan(true);
            }
        }
    }

    private void uppfraeraTima() {
        havdaTimi++;
        if (havdaTimi >= TIMAR.length) {
            havdaTimi = 0;
        }
        timi = TIMAR[havdaTimi];
    }

    public void bordaPellets(PacmanController sc) {
        for (Pellets a : pellets) {
            if (erBorda(a)) {
                pellets.remove(a);
                getChildren().remove(a);
                sc.getLeikur().haekkaStig();
            }
        }
    }

    public boolean erBorda(Pellets a) {
        return a.getBoundsInParent().intersects(fxPacman.getBoundsInParent());
    }

}



