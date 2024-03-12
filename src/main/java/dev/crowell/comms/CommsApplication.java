package dev.crowell.comms;

import dev.crowell.comms.views.LoginScreenView;
import dev.crowell.comms.views.HomeScreenView;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static com.gluonhq.charm.glisten.application.AppManager.HOME_VIEW;

public class CommsApplication extends Application {

    public static final String LOGINSCREEN_VIEW = HOME_VIEW;
    public static final String HOMESCREEN_VIEW = "HomeScreen View";

    private final AppManager appManager = AppManager.initialize(this::postInit);

    @Override
    public void init() {
        appManager.addViewFactory(LOGINSCREEN_VIEW, () -> new LoginScreenView().getView());
        appManager.addViewFactory(HOMESCREEN_VIEW, () -> new HomeScreenView().getView());

        DrawerManager.buildDrawer(appManager);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        appManager.start(primaryStage);
    }

    private void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        scene.getStylesheets().add(CommsApplication.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(CommsApplication.class.getResourceAsStream("/icon.png")));
    }

    public static void main(String args[]) {
        launch(args);
    }
}
