module hi.hbv201g.vidmot {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;



    opens hi.hbv201g.vidmot to javafx.fxml;
    exports hi.hbv201g.vidmot;
    exports hi.hbv201g.vinnsla;
    opens hi.hbv201g.vinnsla to javafx.fxml;
}
