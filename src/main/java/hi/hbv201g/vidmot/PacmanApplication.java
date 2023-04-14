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
        FXMLLoader fxmlLoader = new FXMLLoader(PacmanApplication.class.getResource("Leikbord-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        //PacmanController pc = fxmlLoader.getController();
        //pc.orvatakkar();

        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.FORSIDA);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
