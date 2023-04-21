package hi.hbv201g.vidmot;

import javafx.scene.shape.Circle;

public class Pacman extends Circle implements Afarm, Hnit {
    private final double OFFSET = 1;

    public Pacman() {
        FXMLLoder loader = new FXMLLoder(this, "Pac-man.fxml");
    }

    public int[] hnit(PacmanMaze sc) {
        int[]a=new int[2];
        a[0]=(int)((getCenterX()- sc.MID_VEGG_X)/sc.BREID);
        a[1]= (int)((getCenterY()-sc.MID_VEGG_Y)/sc.HIGTH);
        return a;
    }

    public double getStefna() {
        return getRotate();
    }

    @Override
    public void afarm(boolean[] path, PacmanMaze sc) {
        double att = sc.stfna;
        if (att <= 0) {
            att = 360;
        }
        System.out.println(getRotate());
        if (path[(int) (att / 90) - 1]) {

            if (sc.stfna == 90) {
                setCenterY(getCenterY() - sc.BREID);
            } else if (sc.stfna == 180) {
                setCenterX(getCenterX() - sc.HIGTH);
            } else if (sc.stfna == 270) {
                setCenterY(getCenterY() + sc.BREID);
            } else {
                setCenterX(sc.stfna + sc.HIGTH);
            }
        }

    }
}

