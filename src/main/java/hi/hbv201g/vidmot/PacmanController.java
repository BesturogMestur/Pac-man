package hi.hbv201g.vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PacmanController {
    @FXML
    private Label welcomeText;

    private HashMap<KeyCode, Stefna> map = new HashMap<KeyCode, Stefna>();
    public void orvatakkar(){
        map.put(KeyCode.RIGHT, Stefna.HAEGRI);
        map.put(KeyCode.LEFT, Stefna.VINSTRI);
        map.put(KeyCode.UP, Stefna.UPP);
        map.put(KeyCode.DOWN, Stefna.NIDUR);
    }
    public void initialize(){

    }
}

