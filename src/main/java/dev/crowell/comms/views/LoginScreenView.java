package dev.crowell.comms.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class LoginScreenView {

    public View getView() {
        try {
            View view = FXMLLoader.load(LoginScreenView.class.getResource("loginscreen.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
