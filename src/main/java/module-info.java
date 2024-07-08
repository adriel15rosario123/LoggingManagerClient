module com.rsc.loggingmanagerclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires java.prefs;
    requires com.fasterxml.jackson.databind;

    opens com.rsc.loggingmanagerclient to javafx.fxml;
    opens com.rsc.loggingmanagerclient.views to javafx.fxml;

    exports com.rsc.loggingmanagerclient;
    exports com.rsc.loggingmanagerclient.dtos;
    exports com.rsc.loggingmanagerclient.models;

}