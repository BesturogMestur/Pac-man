package hi.hbv201g.vidmot;

import javafx.scene.shape.Arc;

public class Pacman extends Arc implements Afarm, Hnit {
private final double OFFSET=1;

    public double[] Hnit(){
        double[]a=new double[2];
        a[0]=getCenterX();
        a[1]= getCenterY();
        return a;
    }

    public double getStefna(){
        return getRotate();
    }

    @Override
    public void afarm(boolean[] path) {
        double att = getStefna() - 90;
        if (att < 0) {
            att = 360;
        }
        if (path[(int) (att / 90) - 1]) {
            setCenterX(getCenterX() + Math.cos(Math.toRadians(getRotate())) * OFFSET);
            setCenterY(getCenterY() + Math.sin(Math.toRadians(getRotate())) * OFFSET);
        }
    }
}
