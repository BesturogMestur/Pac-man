package hi.hbv201g.vidmot;

import javafx.scene.shape.Circle;

public class Pellets extends Circle {
    private final String FILE_NAME = "Pallet.fxml";

    public Pellets(){
        FXMLLoder loader = new FXMLLoder(this, FILE_NAME);
    }

}
