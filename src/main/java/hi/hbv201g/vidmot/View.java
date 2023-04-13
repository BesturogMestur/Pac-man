package hi.hbv201g.vidmot;

public enum View {
    FORSIDA("Forsida.fxml"),
    LEIKBORD("Leikbord.fxml");


    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
