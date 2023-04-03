package hi.hbv201g.vidmot;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PacmanMaze {

    private ImageView[][] cellViews;
    private Image pacmanRightImage;
    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image blueGhostImage;
    private Image redGhostImage;
    private Image yellowGhostImage;
    private Image pinkGhostImage;
    private Image wallImage;
    private Image bigDotImage;
    private Image smallDotImage;

    public PacmanMaze() {
        this.pacmanRightImage = new Image(getClass().getResourceAsStream("/myndiroggif/pacmanRight.gif"));
        this.pacmanUpImage = new Image(getClass().getResourceAsStream("/myndiroggif/pacmanUp.gif"));
        this.pacmanDownImage = new Image(getClass().getResourceAsStream("/myndiroggif/pacmanDown.gif"));
        this.pacmanLeftImage = new Image(getClass().getResourceAsStream("/myndiroggif/pacmanLeft.gif"));
        this.redGhostImage = new Image(getClass().getResourceAsStream("/myndiroggif/redghost.gif"));
        this.pinkGhostImage = new Image(getClass().getResourceAsStream("/myndiroggif/pink.gif"));
        this.blueGhostImage = new Image(getClass().getResourceAsStream("/myndiroggif/cyan.gif"));
        this.yellowGhostImage = new Image(getClass().getResourceAsStream("/myndiroggif/yellowghost.gif"));
        this.wallImage = new Image(getClass().getResourceAsStream("/myndiroggif/wall.png"));
        this.bigDotImage = new Image(getClass().getResourceAsStream("/myndiroggif/energizers.png"));
        this.smallDotImage = new Image(getClass().getResourceAsStream("/myndiroggif/pallet.png"));

    }
  
}
