package com.frontend.multisorterfx;

import com.frontend.multisorterfx.statics.SceneSwitcher;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SplashScene extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneSwitcher.setStage(stage,"splash-view.fxml", 320, 240);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), event ->{
            SceneSwitcher.setStage(stage,"sort-view.fxml", 700, 500);
        }));
        timeline.play();
    }

    public static void main(String[] args) {
        launch();
    }
}