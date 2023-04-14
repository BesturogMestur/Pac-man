package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class ForsidaController {
    private PacmanController pacmanController;
    private static MediaPlayer mediaPlayer;
    @FXML
    private Button off;
    @FXML
    private Button on;

    public static void stopSound() {
        mediaPlayer.stop();
    }
    public static void playSound() {
        mediaPlayer.play();
    }

    public void fxHefjaHandler(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.LEIKBORD);
        Media sound = new Media(new File("src/sounds/WakaWaka.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
        });
        mediaPlayer.play();

        pacmanController = (PacmanController) ViewSwitcher.lookup(View.LEIKBORD);
        //pacmanController.byrjaLeik();
    }

}

