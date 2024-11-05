package com.frontend.multisorterfx.statics;

import com.frontend.multisorterfx.SplashScene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {

    private static final double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static final double screenHeight = Screen.getPrimary().getBounds().getHeight();

    public static Stage stage;


    public static void setScene(String relativeFXMLRoute, int percentageWidth, int percentageHeight){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SplashScene.class.getResource(relativeFXMLRoute));
            Scene scene = new Scene(fxmlLoader.load(), (getScreenWidth() * percentageWidth) /100, (getScreenHeight() * percentageHeight) /100 );
            stage.centerOnScreen(); //todo fix stage not centered on screen
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("error setting stage");
            throw new RuntimeException(e);
        }
    }

    public static double getScreenWidth() {
        return screenWidth;
    }

    public static double getScreenHeight() {
        return screenHeight;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        SceneSwitcher.stage = stage;
    }
}
