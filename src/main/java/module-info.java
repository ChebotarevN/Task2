module app.indicator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens app.fx to javafx.fxml;
    exports app.fx;
}