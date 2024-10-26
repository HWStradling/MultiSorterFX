package com.frontend.multisorterfx.statics;

import com.frontend.multisorterfx.SplashScene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {

    private static double screenWidth;
    private static double screenHeight;

    public static Stage stage;


    public SceneSwitcher() {
        setScreenWidth();
        setScreenHeight();
    }
    public static void setScene(String relativeFXMLRoute, int percentageWidth, int percentageHeight){
        try {
//            setScreenWidth(); todo sort issue with stage size not correct when starting scene, stage size has percentage height applied twice if these lines called
//            setScreenHeight();
            FXMLLoader fxmlLoader = new FXMLLoader(SplashScene.class.getResource(relativeFXMLRoute));
            Scene scene = new Scene(fxmlLoader.load(), screenWidth * percentageWidth/100, screenHeight * percentageHeight/100 );
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

    public static void setScreenWidth() {
        SceneSwitcher.screenWidth = Screen.getPrimary().getBounds().getWidth();
    }

    public static double getScreenHeight() {
        return screenHeight;
    }

    public static void setScreenHeight() {
        SceneSwitcher.screenHeight = Screen.getPrimary().getBounds().getHeight();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        SceneSwitcher.stage = stage;
    }
}
