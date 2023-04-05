package hi.hbv201g.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PacmanApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PacmanApplication.class.getResource("bord.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        PacmanController pc = fxmlLoader.getController();
        pc.orvatakkar();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}

