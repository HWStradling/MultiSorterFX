package com.frontend.multisorterfx;
import com.frontend.multisorterfx.statics.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class SortController {
    // Container Elements
    @FXML private HBox rootContainer;
    @FXML private VBox bottomDisplayPane;
    @FXML private VBox buttonPane;
    @FXML private VBox displayPaneContainer;
    @FXML private VBox topDisplayPane;

    // Sorting Buttons
    @FXML private Button bubbleSortButton;
    @FXML private Button insertionSortButton;
    @FXML private Button mergeSortButton;
    @FXML private Button quickSortButton;
    @FXML private Button selectionSortButton;

    @FXML
    public void initialize(){
        rootContainer.setPrefWidth(SceneSwitcher.getStage().getWidth());
        System.out.println(SceneSwitcher.getStage().getWidth());
        rootContainer.setPrefHeight(SceneSwitcher.getStage().getWidth());
        rootContainer.setStyle("-fx-background-color: green;"); // for testing
        double prefWidth = rootContainer.getPrefWidth();
        displayPaneContainer.setPrefWidth( prefWidth/ 2);
        System.out.println( prefWidth/ 2);

        displayPaneContainer.setStyle("-fx-background-color: yellow;");
    }


}
