package hi.hbv201g.vidmot;

public enum View {
    FORSIDA("Forsida.fxml"),
    LEIKBORD("Leikbord-view.fxml");


    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
