package hi.hbv201g.vinnsla;

public enum Stefna {
    NIDUR(270), HAEGRI(0), VINSTRI(180), UPP(90);
    private int stefna;
    Stefna(int stefna) {
        this.stefna = stefna;
    }
    public int getGradur(){
        return stefna;
    }
}
