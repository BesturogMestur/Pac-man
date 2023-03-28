package hi.hbv201g.vidmot;

import javafx.scene.shape.Arc;

public class Pacman extends Arc {

    public double[] getHint(){
        double[]a=new double[2];
        a[0]=getCenterX();
        a[1]= getCenterY();
        return getHint();
    }

    public double getStefna(){
        return getRotate();
    }
}
