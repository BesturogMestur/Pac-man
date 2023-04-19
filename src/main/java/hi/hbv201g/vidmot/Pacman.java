package hi.hbv201g.vidmot;

import javafx.scene.shape.Circle;

public class Pacman extends Circle implements Afarm, Hnit {
    private final double OFFSET = 1;

    public Pacman() {
        FXMLLoder loader = new FXMLLoder(this, "Pac-man.fxml");
    }

    public int[] Hnit() {
        int[]a=new int[2];
        a[0]=(int)getCenterX();
        a[1]= (int)getCenterY();
        return a;
    }

    public double getStefna() {
        return getRotate();
    }

    @Override
    public void afarm(boolean[] path) {
        double att = getStefna();
        if (att <= 0) {
            att = 360;
        }
        if (path[(int) (att / 90) - 1]) {

            if (getRotate() == 90) {
                setCenterY(getCenterY() - 1);
            } else if (getRotate() == 180) {
                setCenterX(getCenterX() - 1);
            } else if (getRotate() == 270) {
                setCenterY(getCenterY() + 1);
            } else {
                setCenterX(getCenterX() + 1);
            }
        }

    }
}

