package hi.hbv201g.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class FaraILeik {

    public static void switchToLeikbord(ActionEvent event, Node rootNode) throws IOException {
        switchView("Leikbord.fxml", event, rootNode);
    }

    private static void switchView(String fxml, ActionEvent event, Node rootNode) throws IOException {
        Parent newView = FXMLLoader.load(FaraILeik.class.getResource(fxml));
        Scene currentScene = rootNode.getScene();
        currentScene.setRoot(newView);
    }
}
