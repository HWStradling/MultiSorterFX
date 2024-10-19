package com.frontend.multisorterfx.statics;

import com.frontend.multisorterfx.SplashScene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {

    public static void setStage(Stage stage, String relativeFXMLRoute, int x, int y){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SplashScene.class.getResource(relativeFXMLRoute));
            Scene scene = new Scene(fxmlLoader.load(), x, y);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("error setting stage");
            throw new RuntimeException(e);
        }
    }

}
