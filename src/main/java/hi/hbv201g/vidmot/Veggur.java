package hi.hbv201g.vidmot;

import javafx.scene.shape.Rectangle;

public class Veggur extends Rectangle {
    private final String FILE_NAME = "Veggur.fxml";

    public Veggur(){
        FXMLLoder loader = new FXMLLoder(this,FILE_NAME);
    }
}
