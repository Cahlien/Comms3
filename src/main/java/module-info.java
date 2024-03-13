module dev.crowell.comms {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires com.gluonhq.attach.storage;
    requires com.gluonhq.attach.display;
    requires com.gluonhq.attach.statusbar;
    requires com.gluonhq.charm.glisten;
    requires com.gluonhq.attach.util;
    requires com.gluonhq.attach.lifecycle;

    exports dev.crowell.comms;
    exports dev.crowell.comms.views;
    opens dev.crowell.comms.views to javafx.fxml;
}