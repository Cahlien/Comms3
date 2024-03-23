package dev.crowell.comms.views;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoginScreenPresenter {

    @FXML
    private View loginscreen;

    @FXML
    private Label label;

    public void initialize() {
        loginscreen.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = AppManager.getInstance().getAppBar();

                ResourceBundle bundle = ResourceBundle.getBundle("dev.crowell.comms.i18n.MessagesBundle", Locale.getDefault());
                appBar.setTitleText(bundle.getString("appBar.title"));
            }
        });
    }
    
    @FXML
    void buttonClick() {
        label.setText("Hello JavaFX Universe!");
    }
    
}
