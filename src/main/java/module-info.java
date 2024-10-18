module com.frontend.multisorterfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.frontend.multisorterfx to javafx.fxml;
    exports com.frontend.multisorterfx;
    exports com.backend.multisorterfx;
    opens com.backend.multisorterfx to javafx.fxml;
}