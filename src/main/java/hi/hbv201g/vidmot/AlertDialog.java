package hi.hbv201g.vidmot;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class AlertDialog extends Alert {
    public static final ButtonType BYRJA = new ButtonType(
            "Byrja nýjan leik", ButtonBar.ButtonData.OK_DONE);
    public static final ButtonType HAETTA = new ButtonType("Leik lokið", ButtonBar.ButtonData.CANCEL_CLOSE);

    public AlertDialog(String title, String header, String spurning){
        super(AlertType.NONE, spurning, BYRJA,HAETTA);
        setTitle(title);
        setHeaderText(header);

    }

}
