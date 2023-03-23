module hi.hbv201g.vidmot {
    requires javafx.controls;
    requires javafx.fxml;


    opens hi.hbv201g.vidmot to javafx.fxml;
    exports hi.hbv201g.vidmot;
}