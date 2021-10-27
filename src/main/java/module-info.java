module cz.bakterio.passwordgenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens cz.bakterio.passwordgenerator to javafx.fxml;
    exports cz.bakterio.passwordgenerator;
}