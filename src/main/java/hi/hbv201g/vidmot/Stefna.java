package hi.hbv201g.vidmot;

public enum Stefna {
    NIDUR(270), HAEGRI(360), VINSTRI(180), UPP(90);

    private final int stefna;

    Stefna(int stefna) {
        this.stefna = stefna;
    }
    public int getGradur(){
        return stefna;
    }
}
