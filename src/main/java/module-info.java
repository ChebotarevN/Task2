module app.indicator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens app.indicator to javafx.fxml;
    exports app.indicator;
}