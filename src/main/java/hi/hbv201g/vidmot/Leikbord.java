package hi.hbv201g.vidmot;

import javafx.scene.layout.GridPane;

public class Leikbord extends GridPane {
    public Leikbord(){
        FXMLLoder loader = new FXMLLoder(this, "Leikbord-view.fxml");
    }
}
