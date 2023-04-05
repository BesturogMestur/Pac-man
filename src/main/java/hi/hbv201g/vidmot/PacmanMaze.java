package hi.hbv201g.vidmot;


import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PacmanMaze extends Application {

    private Image pacmanRightImage;
    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image redGhostImage;
    private Image pinkGhostImage;
    private Image blueGhostImage;
    private Image yellowGhostImage;
    private Image wallImage;
    private Image bigDotImage;
    private Image smallDotImage;
    private int width;
    private int height;
    private int numCols;
    private int numRows;
    private int cellSize;
    private GridPane gridPane;


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Initialize images
        pacmanRightImage = new Image(getClass().getResourceAsStream("/myndiroggif/pacmanRight.gif"));
        pacmanUpImage = new Image(getClass().getResourceAsStream("/myndiroggif/pacmanUp.gif"));
        pacmanDownImage = new Image(getClass().getResourceAsStream("/myndiroggif/pacmanDown.gif"));
        pacmanLeftImage = new Image(getClass().getResourceAsStream("/myndiroggif/pacmanLeft.gif"));
        redGhostImage = new Image(getClass().getResourceAsStream("/myndiroggif/redghost.gif"));
        pinkGhostImage = new Image(getClass().getResourceAsStream("/myndiroggif/pink.gif"));
        blueGhostImage = new Image(getClass().getResourceAsStream("/myndiroggif/cyan.gif"));
        yellowGhostImage = new Image(getClass().getResourceAsStream("/myndiroggif/yellowghost.gif"));
        wallImage = new Image(getClass().getResourceAsStream("/myndiroggif/wall.png"));
        bigDotImage = new Image(getClass().getResourceAsStream("/myndiroggif/energizers.png"));
        smallDotImage = new Image(getClass().getResourceAsStream("/myndiroggif/pallet.png"));

    }
}

