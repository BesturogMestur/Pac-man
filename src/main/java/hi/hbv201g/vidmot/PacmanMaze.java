package hi.hbv201g.vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
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
    private final double BREID=46.1538;
    private final double HIGTH =28.5714;
    private final int[] TIMAR = {10, 8, 10, 2};
    private int havdaTimi = 0;
    private int timi;
    @FXML
    Pacman fxPacman;
    private Draugar blinky;
    private Draugar inky;
    private Draugar pinky;
    private Draugar clyde;
    private ObservableList<Pellets> pellets = FXCollections.observableArrayList();

    public PacmanMaze() {
        FXMLLoder loader = new FXMLLoder(this, "PacmanMaze.fxml");
        setMaze();
        nyrLeikur();
    }

    private void setMaze() {
        for(int j=0;j<MAX_ROW;j++){
            for (int i = 0; i<MAX_COL;i++){
                if(!maze[i][j]){
                    Veggur v = new Veggur();
                    getChildren().add(v);

                    v.setWidth(47.0);
                    v.setHeight(31.0);

                    v.setX((i*BREID));
                    v.setY((j* HIGTH));
                }
            }
        }
    }

    public void nyrLeikur() {
        setPecman(6, 10);
        timi = TIMAR[havdaTimi];
        setDraugar();
        //setPellets();

    }

    private void setPecman(int x, int y) {
        fxPacman = new Pacman();

        getChildren().add(fxPacman);
        fxPacman.setCenterX(BREID*x);
        fxPacman.setCenterY(HIGTH*y);
    }

    private void setDraugar() {
        blinky = new Blinky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, BLINKY_HOME);
        blinky.getStyleClass().add("redghost.gif");
        blinky.setFill(Color.rgb(255,0,0));
        getChildren().add(blinky);
        blinky.setCenterX((BREID)*1);
        blinky.setCenterY((HIGTH)*1);

        inky = new Inky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, MESTA_LEGNT_FRA_UPPHAF, blinky);
        inky.getStyleClass().add("cyan.gif");
        pinky = new Pinky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, UPPHAFS_PUNKTUR);
        pinky.getStyleClass().add("pink.gif");
        clyde = new Clyde(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, CLYDE_HOME);
        clyde.getStyleClass().add("yellowghost.gif");

    }

    public void setPellets() {
        for (int i = 1; i < MAX_COL - 1; i++) {
            for (int j = 1; j < MAX_ROW - 1; j++) {
                if (!((j == 5 || j == 6 || j == 7) && (i == 7 || i == 8))) {
                    if (maze[i][j]) {
                        Pellets p = new Pellets();
                        pellets.add(p);
                        getChildren().add(p);
                        p.setCenterX((BREID/2)*j);
                        p.setCenterY((HIGTH/2)*i);
                    }
                }
            }
        }
    }

    /**
     * þesso aferð tekur in kommu tölu og stillir síðan stfnu þess á botaum.
     *
     * @param d Kommu tala
     */
    public void setStefna(Double d) {
        fxPacman.setRotate(d);
        //System.out.println(fxPacman.getRotate());
    }

    public void pacmanAfram() {
        fxPacman.afarm(walls(fxPacman.Hnit()));
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
        int[] a = d.Hnit();

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



        d.afarm(walls(d.Hnit()));
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



