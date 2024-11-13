package com.frontend.multisorterfx;

import com.backend.multisorterfx.BubbleSort;
import com.backend.multisorterfx.InsertionSort;
import com.backend.multisorterfx.Quicksort;
import com.backend.multisorterfx.statics.UnsortedArray;
import com.frontend.multisorterfx.statics.SceneSwitcher;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SplashScene extends Application {

    private final double splashSceneDuration = 3000;
    @Override
    public void start(Stage stage) throws IOException {
        SceneSwitcher.setStage(stage);
        SceneSwitcher.setScene("splash-view.fxml", 20, 20);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(splashSceneDuration), event ->{
            SceneSwitcher.setScene("sort-view.fxml", 50, 50);
        }));
        timeline.play();
    }

    public static void main(String[] args) {
        new Quicksort().sort(UnsortedArray.getUnsortedArray(10, 100));
        new InsertionSort().sort(UnsortedArray.getUnsortedArray(10, 100));
        new BubbleSort().sort(UnsortedArray.getUnsortedArray(10, 100));

        launch();
    }
}