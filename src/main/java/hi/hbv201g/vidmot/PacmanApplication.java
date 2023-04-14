package hi.hbv201g.vidmot;

import hi.hbv201g.vinnsla.MusicPlayer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PacmanApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(PacmanApplication.class.getResource("Forsida.fxml"));
       // Scene scene = new Scene(fxmlLoader.load(), 500, 500);

        //PacmanController pc = fxmlLoader.getController();
        //pc.orvatakkar();
        var scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.FORSIDA);

        stage.setScene(scene);
        stage.setTitle("Pac-Man");
        stage.show();

        //MusicPlayer music = new MusicPlayer("src/sounds/soundtrack.mp3");
        //music.play();
        //music.setVolume(0.5);
        //pc.byrjaLeik();

    }


    public static void main(String[] args) {
        launch();
    }
}
