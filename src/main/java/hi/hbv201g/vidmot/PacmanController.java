package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.Leikur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.HashMap;
import java.util.Optional;

public class PacmanController {
    @FXML
    private Label fxStig;
    @FXML
    private PacmanMaze maze;
    private Leikur leikur;
    private Timeline timeline;

    private HashMap<KeyCode, Stefna> map = new HashMap<KeyCode,Stefna>();

    public void initialize() {
        leikur = new Leikur();
        fxStig.textProperty().bind(leikur.stiginproperty().asString());

    }

    public void byrjaLeik() {
        KeyFrame k = new KeyFrame(Duration.millis(100.0),
                e -> {
                    maze.pacmanAfram();
                    //maze.bordaPellets(this);
                    //maze.aframDraugar(this);

                });
        timeline = new Timeline(k);
        timeline.setCycleCount(Timeline.INDEFINITE);
        maze.nyrLeikur();
        timeline.play();

    }
    

    public void orvatakkar() {
        map.put(KeyCode.RIGHT, Stefna.HAEGRI);
        map.put(KeyCode.LEFT, Stefna.VINSTRI);
        map.put(KeyCode.UP, Stefna.UPP);
        map.put(KeyCode.DOWN, Stefna.NIDUR);
        fxStig.getScene().addEventFilter(KeyEvent.ANY, event -> {
            try {
                this.setStefna(map.get(event.getCode()).getGradur());
                //this.maze.pacmanAfram();
            } catch (NullPointerException e) {
                event.consume();
            }
        });
    }

    private void setStefna(double d) {
        maze.setStefna(d);
        //maze.pacmanAfram();
    }

    public Leikur getLeikur() {
        return leikur;
    }

    public void leikLokid() {
        leikur.leikLokid();
        timeline.stop();
        //það væri fínt að færa þetta í áfram hjá pac man
        ForsidaController.stopSound();
        Media sound = new Media(new File("src/sounds/Death.mp3").toURI().toString());
        MediaPlayer PacManDo = new MediaPlayer(sound);
        PacManDo.play();
    }

    public void nyrLeikur() {
        maze.nyrLeikur();
        timeline.play();
    }

    public void showAlertDialog() {
        Alert alert = new AlertDialog("", "Pac-man", "Þú hefur verið gómaður, vilt þú byrja nýjan leik?");
        Optional<ButtonType> b = alert.showAndWait();
        if (b.isPresent() && !b.get().getButtonData().isCancelButton()) {
            nyrLeikur();
        }
    }

    public void turnOffMusic(ActionEvent event) {
        ForsidaController.stopSound();
    }

    public void turnOnMusic(ActionEvent event) {
        ForsidaController.playSound();
    }
}

