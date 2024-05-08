module com.rsc.loggingmanagerclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rsc.loggingmanagerclient to javafx.fxml;
    exports com.rsc.loggingmanagerclient;
}