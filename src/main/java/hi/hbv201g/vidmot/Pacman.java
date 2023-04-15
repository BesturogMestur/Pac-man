package hi.hbv201g.vidmot;

import hi.hbv201g.vidmot.FXMLLoder;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

public class Pacman extends Circle implements Afarm, Hnit {
private final double OFFSET=1;
private PacmanMaze pacmanMaze;

    public Pacman(){
        FXMLLoder loader = new FXMLLoder(this,"Pac-man.fxml");
        pacmanMaze=(PacmanMaze) ViewSwitcher.lookup(View.MAZE);
    }
    public double[] Hnit(){
        double[]a=new double[2];
        a[0]=getCenterX();
        a[1]= getCenterY();
        return a;
    }

    public double getStefna(){
        return getRotate();
    }

    public boolean erBorda(Pellets a){
        return getBoundsInParent().intersects(a.getBoundsInParent());
    }

    @Override
    public void afarm(boolean[] path) {
        double att = getStefna() - 90;
        if (att < 0) {
            att = 360;
        }
        if (path[(int) (att / 90) - 1]) {
            double a = getCenterX() + Math.cos(Math.toRadians(getRotate())) * OFFSET;
            double b = getCenterY() + Math.sin(Math.toRadians(getRotate())) * OFFSET;
            pacmanMaze.faeraPcak(a,b);

        }
    }
}
