package dev.crowell.comms;

import com.gluonhq.attach.lifecycle.LifecycleService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.attach.util.Services;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.application.ViewStackPolicy;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.control.NavigationDrawer.ViewItem;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.image.Image;

import java.util.Objects;

import static dev.crowell.comms.CommsApplication.LOGINSCREEN_VIEW;
import static dev.crowell.comms.CommsApplication.HOMESCREEN_VIEW;

public class DrawerManager {

    public static void buildDrawer(AppManager app) {
        NavigationDrawer drawer = app.getDrawer();
        
        NavigationDrawer.Header header = new NavigationDrawer.Header("Gluon Application",
                "Multi View Project",
                new Avatar(21, new Image(Objects.requireNonNull(DrawerManager.class.getResourceAsStream("/icon.png")))));
        drawer.setHeader(header);
        
        final Item loginscreenItem = new ViewItem("LoginScreen", MaterialDesignIcon.HOME.graphic(), LOGINSCREEN_VIEW, ViewStackPolicy.SKIP);
        final Item homescreenItem = new ViewItem("HomeScreen", MaterialDesignIcon.DASHBOARD.graphic(), HOMESCREEN_VIEW);
        drawer.getItems().addAll(loginscreenItem, homescreenItem);
        
        if (Platform.isDesktop()) {
            final Item quitItem = new Item("Quit", MaterialDesignIcon.EXIT_TO_APP.graphic());
            quitItem.selectedProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    if(Services.get(LifecycleService.class).isPresent()) {
                        app.setTitle("Service present");
                    } else {
                        System.exit(0);
                    }
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                }
            });
            drawer.getItems().add(quitItem);
        }
    }
}