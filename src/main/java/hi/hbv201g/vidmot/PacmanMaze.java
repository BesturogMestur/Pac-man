package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class PacmanMaze extends GridPane {
    private final String FILE_NAME = "Leikbord.fxml";
    private final double[] HOME = {6, 5};
    private final double[] UPPHAFS_PUNKTUR = {0, 0};
    private final double[] MESTA_LEGNT_FRA_UPPHAF = {getColumnCount(), getRowCount()};
    private final double[] BLINKY_HOME = {getColumnCount(), 0};
    private final double[] CLYDE_HOME = {0, getRowCount()};
    private boolean[][] maze;
    private final int[] TIMAR = {10, 8, 10, 2};
    private int havdaTimi = 0;
    private int timi;

    private Pacman fxPacman;
    private Blinky blinky;
    private Inky inky;
    private Pinky pinky;
    private Clyde clyde;
    private ObservableList<Pellets> pellets = FXCollections.observableArrayList();

    private PacmanController pacmanController;

    public PacmanMaze() {
        FXMLLoder loader = new FXMLLoder(this, "PacmanMaze.fxml");
        // this.pacmanController = pacmanController;
        setMaze();
        nyrLeikur();
    }

    private void setMaze() {
        maze = new boolean[getColumnCount()][getRowCount()];
        for (int i = 0; i < getColumnCount(); i++) {
            for (int j = 0; j < getRowCount(); j++) {
                maze[i][j] = true;
            }
        }
        for (Node child : getChildren()) {
            if (child instanceof Veggur) {
                int i = getColumnIndex(child);
                int j = getRowIndex(child);
                maze[i][j] = false;
            }
        }
    }

    public void nyrLeikur() {
        setPecman();
        timi = TIMAR[havdaTimi];
        setDraugar();
        setPellets();
    }

    private void setPecman(){
        fxPacman = new Pacman();
        add(fxPacman,6,10);
        setHalignment(fxPacman,HPos.CENTER);
        setValignment(fxPacman,VPos.CENTER);
    }

    private void setDraugar() {
        blinky = new Blinky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, BLINKY_HOME);
        inky = new Inky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, MESTA_LEGNT_FRA_UPPHAF, blinky);
        pinky = new Pinky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, UPPHAFS_PUNKTUR);
        clyde = new Clyde(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, CLYDE_HOME);

    }

    public void setPellets() {
        for (int i = 1; i < getColumnCount()-1; i++) {
            for (int j = 1; j < getRowCount()-1; j++) {
                if(!((i ==5||i==6||i==7) && (j==7||j==8))){
                    if (maze[i][j]) {
                        Pellets p = new Pellets();
                        pellets.add(p);
                        add(p, i, j);
                        setHalignment(p, HPos.CENTER);
                        setValignment(p, VPos.CENTER);
                    }
                }
            }
        }
    }

    /**
     * þesso aferð tekur in kommu tölu og stillir síðan stfnu þess á botaum.
     * @param d Kommu tala
     */
    public void setStefna(Double d) {
        fxPacman.setRotate(d);
        System.out.println(fxPacman.getRotate());
    }

    public void pacmanAfram() {
        fxPacman.afarm(walls(fxPacman));
    }

    public void faeraPcak(double a, double b) {
        setColumnIndex(fxPacman,(int) (getColumnIndex(fxPacman) + a));
        setRowIndex(fxPacman, (int) (getRowIndex(fxPacman) + b));
        //setConstraints(fxPacman, (int) (getColumnIndex(fxPacman) + a), (int) (getRowIndex(fxPacman) + b));
    }

    public void aframDraugar() {
        aframDurgar(blinky);
        aframDurgar(inky);
        aframDurgar(pinky);
        aframDurgar(clyde);
        if (timi <= 0) {
            uppfraeraTima();
        }
    }

    private void aframDurgar(Draugar d) {
        int[] a = new int[2];
        a[0] = getColumnIndex(d);
        a[1] = getRowIndex(d);

        if (timi <= 0) {
            if (d.elta) {
                d.setElta(false);
            } else {
                d.setElta(true);
            }
        }
        if (a[0] == 6 && a[1] == 5) {
            d.setEtan(false);
            d.setRotate(Stefna.UPP.getGradur());
        }


        d.afarm(walls(d));
        athugaPacman(d);
    }

    public void fearDrauga(double a, double b, Draugar d) {
        setConstraints(d, (int) (getColumnIndex(d) + a), (int) (getRowIndex(d) + b));
    }

    private boolean[] walls(Node n) {
        int[] a = new int[2];
        boolean[] walls = new boolean[4];
        a[0] = getColumnIndex(n);
        a[1] = getRowIndex(n);

        for (int i = 0; i < walls.length; i++) {
            if (i % 2 == 0) {
                if (i == 0) {
                    walls[i] = maze[a[0] + 1][a[1]];
                } else {
                    walls[i] = maze[a[0] - 1][a[1]];
                }

            } else {
                if (i == 1) {
                    walls[i] = maze[a[0]][a[1] + 1];
                } else {
                    walls[i] = maze[a[0]][a[1] - 1];
                }
            }
        }
        return walls;

    }

    private void athugaPacman(Draugar d) {
        if (d.getBoundsInParent().intersects(fxPacman.getBoundsInParent())) {
            if (!d.hraedir && !d.etan) {
                pacmanController.leikLokid();
                pacmanController.showAlertDialog();
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

    public void bordaPellets() {
        for (Pellets a : pellets) {
            if (fxPacman.erBorda(a)) {
                pellets.remove(a);
                pacmanController.getLeikur().haekkaStig();
                getChildren().remove(a);
            }
        }
    }

}



