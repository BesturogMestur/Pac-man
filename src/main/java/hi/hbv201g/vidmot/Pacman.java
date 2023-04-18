package hi.hbv201g.vidmot;

import javafx.scene.shape.Circle;

public class Pacman extends Circle implements Afarm, Hnit {
    private final double OFFSET = 1;

    public Pacman() {
        FXMLLoder loader = new FXMLLoder(this, "Pac-man.fxml");
    }

    public int[] Hnit(PacmanMaze sc) {
        int[] a = new int[2];
        a[0] = sc.getColumnIndex(this);
        a[1] = sc.getRowIndex(this);
        return a;
    }

    public double getStefna() {
        return getRotate();
    }

    @Override
    public void afarm(boolean[] path, PacmanMaze sc) {
        double att = getStefna() - 90;
        if (att < 0) {
            att = 360;
        }
        if (path[(int) (att / 90) - 1]) {
            int a = 0;
            int b = 0;
            if (getRotate() == 90) {
                b-=1;
            } else if (getRotate() == 180) {
                a -= 1;
            } else if (getRotate() == 270) {
                b += 1;
            } else {
                a += 1;
            }

            sc.faeraPcak(a, b);
        }
    }
}
