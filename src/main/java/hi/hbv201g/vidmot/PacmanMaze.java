package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class PacmanMaze extends GridPane {
    private final String FILE_NAME = "Leikbord.fxml";
    private final double[] HOME = {6, 5};
    private final double[] UPPHAFS_PUNKTUR = {0, 0};
    private final double[] MESTA_LEGNT_FRA_UPPHAF = {getColumnCount(), getRowCount()};
    private final double[] BLINKY_HOME = {getColumnCount(), 0};
    private final double[] CLYDE_HOME = {0, getRowCount()};
    private final boolean[][] MAZE = {{false, false, false, false, false, false, false, false, false, false, false,
            false, false},
            {false, true, true, true, true, true, true, true, true, true, true, true, false},
            {false, true, false, false, false, false, true, false, false, false, false, true, false},
            {false, true, false, true, true, true, true, true, true, true, false, true, false},
            {false, true, false, true, false, false, false, false, false, true, false, true, false},
            {false, true, true, true, true, true, true, true, true, true, true, true, false},
            {false, true, false, true, false, false, false, false, false, true, false, true, false},
            {true, true, false, true, false, false, false, false, false, true, false, true, true},
            {false, true, false, true, false, false, false, false, false, true, false, true, false},
            {false, true, true, true, false, false, false, false, false, true, true, true, false},
            {false, true, false, true, true, true, true, true, true, true, false, true, false},
            {false, true, false, true, false, false, false, false, false, true, false, true, false},
            {false, true, true, true, true, true, true, true, true, true, true, true, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false}};
    private final int[] TIMAR = {10, 8, 10, 2};
    private int havdaTimi = 0;
    private int timi;
    @FXML
    Pacman fxPacman;
    private Blinky blinky;
    private Inky inky;
    private Pinky pinky;
    private Clyde clyde;
    private ObservableList<Pellets> pellets = FXCollections.observableArrayList();

    private PacmanController pacmanController;

    public PacmanMaze(PacmanController pacmanController) {
        FXMLLoder loader = new FXMLLoder(this, FILE_NAME);
        this.pacmanController = pacmanController;
        nyrLeikur();
    }

    public void nyrLeikur() {
        fxPacman = new Pacman();
        add(fxPacman,1,1);
        timi = TIMAR[havdaTimi];
        setDraugar();
        setPellets();
    }

    private void setDraugar() {
        blinky = new Blinky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, BLINKY_HOME);
        inky = new Inky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, MESTA_LEGNT_FRA_UPPHAF, blinky);
        pinky = new Pinky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, UPPHAFS_PUNKTUR);
        clyde = new Clyde(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, CLYDE_HOME);

    }

    public void setPellets() {
        for (int i = 1; i < MAZE.length - 1; i++) {
            for (int j = 1; j < MAZE.length - 1; j++) {
                if (MAZE[i][j]) {
                    Pellets p = new Pellets();
                    pellets.add(p);
                    setConstraints(p,i,j);
                }
            }
        }
    }

    public void pacmanAfram() {
        fxPacman.afarm(walls(fxPacman));
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

    private boolean[] walls(Node n) {
        int[] a = new int[2];
        boolean[] walls = new boolean[4];
        a[0] = getColumnIndex(n);
        a[1] = getRowIndex(n);

        for (int i = 0; i < walls.length; i++) {
            if (i % 2 == 0) {
                if (i == 0) {
                    walls[i] = MAZE[a[0] + 1][a[1]];
                } else {
                    walls[i] = MAZE[a[0] - 1][a[1]];
                }

            } else {
                if (i == 1) {
                    walls[i] = MAZE[a[0]][a[1] + 1];
                } else {
                    walls[i] = MAZE[a[0]][a[1] - 1];
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



