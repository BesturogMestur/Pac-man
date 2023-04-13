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
    private final double[] CLYDE_HOME = {0,getRowCount()};
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
        inky = new Inky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME,MESTA_LEGNT_FRA_UPPHAF,blinky);
        pinky = new Pinky(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME,UPPHAFS_PUNKTUR);
        clyde = new Clyde(fxPacman, UPPHAFS_PUNKTUR, MESTA_LEGNT_FRA_UPPHAF, HOME, CLYDE_HOME);

    }

}

