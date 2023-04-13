package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.Blinky;
import hi.hbv201g.vinnsla.Clyde;
import hi.hbv201g.vinnsla.Inky;
import hi.hbv201g.vinnsla.Pinky;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class PacmanMaze extends GridPane {
    private final String FILE_NAME = "Leikbord.fxml";
    private final double[] HOME = {6, 6};
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
    @FXML
    Pacman fxPacman;
    private Blinky blinky;
    private Inky inky;
    private Pinky pinky;
    private Clyde clyde;

    public PacmanMaze() {
        FXMLLoder maze = new FXMLLoder(this, FILE_NAME);
        setDraugar();
    }

    private void setDraugar() {
        blinky = new Blinky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, BLINKY_HOME);
        inky = new Inky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, MESTA_LEGNT_FRA_UPPHAF, blinky);
        pinky = new Pinky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, UPPHAFS_PUNKTUR);
        clyde = new Clyde(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, CLYDE_HOME);

    }

    public void aframDraugar() {
        aframDurgar(blinky);
        aframDurgar(inky);
        aframDurgar(pinky);
        aframDurgar(clyde);
    }

    private void aframDurgar(Draugar d) {
        int[] a = new int[2];
        boolean[] walls = new boolean[4];
        a[0] = getColumnIndex(d);
        a[1] = getRowIndex(d);
        for(int i = 0; i < walls.length;i++){
            if (i%2==0){
                if(i==0){
                    walls[i]=MAZE[a[0]+1][a[1]];
                }else {
                    walls[i]=MAZE[a[0]-1][a[1]];
                }

            }else {
                if(i==1){
                    walls[i]=MAZE[a[0]][a[1]+1];
                }else {
                    walls[i]=MAZE[a[0]][a[1]-1];
                }
                }
            }
        d.afarm(walls);
        }

    }



