package hi.hbv201g.vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


 public class PacmanController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

    }
}

