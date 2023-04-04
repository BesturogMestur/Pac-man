package hi.hbv201g.vinnsla;

import javafx.application.Application;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.media.Media;

import java.io.File;


public class MusicPlayer {
    private MediaPlayer mediaPlayer;
    public MusicPlayer(String path){
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
    }

    public void play(){
        mediaPlayer.play();
    }
    public void setVolume(Double volume){
        mediaPlayer.setVolume(volume);
    }
    public void stop(){
        mediaPlayer.stop();
    }
    public void pause(){
        mediaPlayer.pause();
    }


}
