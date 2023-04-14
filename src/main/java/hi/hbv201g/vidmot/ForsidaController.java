package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class ForsidaController {
    private PacmanController pacmanController;
    public void fxHefjaHandler(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.LEIKBORD);
       // MusicPlayer music = new MusicPlayer("src/sounds/Chomp.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File("src/sounds/WakaWaka.mp3").toURI().toString()));
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
        });
        mediaPlayer.play();
        //music.play();
        //music.setVolume(0.5);
        mediaPlayer.setVolume(0.5);
        pacmanController = (PacmanController) ViewSwitcher.lookup(View.LEIKBORD);
        //pacmanController.byrjaLeik();
    }
}
