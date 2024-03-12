package dev.crowell.comms.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class HomeScreenView {
    
    public View getView() {
        try {
            View view = FXMLLoader.load(HomeScreenView.class.getResource("homescreen.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
