package dev.crowell.comms.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;

public class HomeScreenView {
    
    public View getView() {
        try {
            return FXMLLoader.load(Objects.requireNonNull(HomeScreenView.class.getResource("homescreen.fxml")));
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
