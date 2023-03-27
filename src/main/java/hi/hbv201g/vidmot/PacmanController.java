package hi.hbv201g.vidmot;

import hi.hbv201g.vinsla.Stefna;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

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