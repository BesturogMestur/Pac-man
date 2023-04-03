package hi.hbv201g.vidmot;

import javafx.scene.shape.Arc;

public class Pacman extends Arc implements Afarm {
private final double OFFSET=1;

    public double[] getHint(){
        double[]a=new double[2];
        a[0]=getCenterX();
        a[1]= getCenterY();
        return getHint();
    }

    public double getStefna(){
        return getRotate();
    }

    @Override
    public void afarm(boolean[] path) {
        setCenterX(getCenterX() + Math.cos(Math.toRadians(getRotate())) * OFFSET);
        setCenterY(getCenterY() + Math.sin(Math.toRadians(getRotate())) * OFFSET);
    }
}
