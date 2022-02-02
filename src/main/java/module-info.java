module cz.polacek.paragraphanalizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;


    opens cz.polacek.paragraphanalizer to javafx.fxml;
    exports cz.polacek.paragraphanalizer;
}