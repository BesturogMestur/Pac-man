package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.Leikur;
import hi.hbv201g.vinnsla.Stefna;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class PacmanController {
    @FXML
    private Label fxStig;
    @FXML
    private PacmanMaze maze;
    private Leikur leikur;
    private Timeline timeline;

    private HashMap<KeyCode, Stefna> map = new HashMap<KeyCode, Stefna>();
    public void orvatakkar(){
        map.put(KeyCode.RIGHT, Stefna.HAEGRI);
        map.put(KeyCode.LEFT, Stefna.VINSTRI);
        map.put(KeyCode.UP, Stefna.UPP);
        map.put(KeyCode.DOWN, Stefna.NIDUR);
    }
    public void initialize(){
        leikur = new Leikur();
        fxStig.textProperty().bind(leikur.stiginproperty().asString());
    }
    public void byrjaLeik(){
        KeyFrame k = new KeyFrame(Duration.millis(100.0),
                e -> {
            maze.bordaPellets();
            maze.aframDraugar();

                });
        timeline = new Timeline(k);
        timeline.setCycleCount(Timeline.INDEFINITE);
        maze.nyrLeikur();
        timeline.play();

    }
    public Leikur getLeikur(){
        return leikur;
    }
    public void leikLokid(){
        leikur.leikLokid();
        timeline.stop();
    }
    public void nyrLeikur(){
        maze.nyrLeikur();
        timeline.play();
    }
    public void showAlertDialog(){
        Alert alert = new AlertDialog("","Pac-man", "Þú hefur verið gómaður, vilt þú byrja nýjan leik?");
        Optional<ButtonType> b = alert.showAndWait();
        if(b.isPresent() && !b.get().getButtonData().isCancelButton()){
            nyrLeikur();
        }
    }

}

