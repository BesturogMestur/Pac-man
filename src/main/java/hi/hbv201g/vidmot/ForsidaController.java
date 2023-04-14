package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ForsidaController {
    private PacmanController pacmanController;
    public void fxHefjaHandler(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.LEIKBORD);
        MusicPlayer music = new MusicPlayer("src/sounds/Chomp.mp3");
        music.play();
        music.setVolume(0.5);
        pacmanController = (PacmanController) ViewSwitcher.lookup(View.LEIKBORD);
        //pacmanController.byrjaLeik();
    }
}
