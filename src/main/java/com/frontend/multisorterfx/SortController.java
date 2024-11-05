package com.frontend.multisorterfx;

import com.backend.multisorterfx.*;
import com.backend.multisorterfx.statics.UnsortedArray;
import com.frontend.multisorterfx.statics.SceneSwitcher;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.security.InvalidParameterException;
import java.util.Arrays;


public class SortController {
    // Container Elements
    @FXML
    private HBox rootContainer;
    @FXML
    private VBox bottomDisplayPane;
    @FXML
    private VBox buttonPane;
    @FXML
    private VBox displayPaneContainer;
    @FXML
    private VBox topDisplayPane;

    // Sorting Buttons
    @FXML
    private Button bubbleSortButton;
    @FXML
    private Button insertionSortButton;
    @FXML
    private Button mergeSortButton;
    @FXML
    private Button quickSortButton;
    @FXML
    private Button selectionSortButton;

    // Array Generation Elements and Variables
    @FXML
    private Button generateButton;
    @FXML
    private Slider arrayLengthSlider;
    @FXML
    private Spinner<Integer> integerRange;
    @FXML
    private Label unsortedArrayLabel;
    private int[] unsortedArray = new int[10];

    //Sorted Array Elements
    @FXML
    private Label sortedArrayLabel;
    @FXML
    private Label algorithmNameLabel;
    private int[] sortingArray = new int[10];

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            rootContainer.setPrefWidth(SceneSwitcher.getStage().getWidth());
            rootContainer.setPrefHeight(SceneSwitcher.getStage().getHeight());
            rootContainer.setStyle("-fx-background-color: green;"); // for testing

            displayPaneContainer.setPrefWidth(rootContainer.getPrefWidth() / 2);
            displayPaneContainer.setStyle("-fx-background-color: yellow;"); // for testing

            topDisplayPane.setPrefWidth(displayPaneContainer.getPrefWidth());
            topDisplayPane.setStyle("-fx-background-color: blue;"); // for testing

            bottomDisplayPane.setPrefWidth(displayPaneContainer.getPrefWidth());
            bottomDisplayPane.setStyle("-fx-background-color: red"); // for testing

            arrayLengthSlider.setValue(1);
            arrayLengthSlider.setStyle(""); //todo how to change tick color

            IntegerSpinnerValueFactory valueFactory = new IntegerSpinnerValueFactory(1, 100, 50); // min, max, initial value
            integerRange.setValueFactory(valueFactory);

            displayUnsortedArray();
        });
    }

    public void onQuicksortButtonAction(ActionEvent actionEvent) {
        sortCaller("quick");
    }
    public void onMergesortButtonAction(ActionEvent actionEvent) {
        sortCaller("merge");
    }

    public void onInsertionsortButtonAction(ActionEvent actionEvent) {
        sortCaller("insertion");
    }

    public void onBubblesortButtonAction(ActionEvent actionEvent) {
        sortCaller("bubble");
    }

    public void onSelectionsortButtonAction(ActionEvent actionEvent) {
        sortCaller("selection");
    }

    public void onGenerateButtonAction(ActionEvent actionEvent) {
        //todo push to notification stack/make notification stack
        try {
            unsortedArray = UnsortedArray.getUnsortedArray((int) arrayLengthSlider.getValue(), integerRange.getValue());
        } catch (Exception e) {
            System.out.print("slider value cast failed or get int range, using default array length of 5");
            unsortedArray = UnsortedArray.getUnsortedArray(10, 10);
        }
        displayUnsortedArray();
        resetSortingArray();
    }

    private void sortCaller(String x){
        System.out.println(x);
        resetSortingArray();
        SortingAlgorithm sortingAlgorythm;
        switch (x){
            case "quick":
                sortingAlgorythm = new Quicksort();
                algorithmNameLabel.setText("QuickSort:");
                break;
            case "merge":
                sortingAlgorythm = new Mergesort();
                algorithmNameLabel.setText("MergeSort:");
                break;
            case "insertion":
                sortingAlgorythm = new InsertionSort();
                algorithmNameLabel.setText("InsertionSort:");
                break;
            case "bubble":
                sortingAlgorythm = new BubbleSort();
                algorithmNameLabel.setText("BubbleSort:");
                break;
            case "selection":
                sortingAlgorythm = new SelectionSort();
                algorithmNameLabel.setText("SelectionSort:");
                break;
            default:
                sortingAlgorythm = new InsertionSort();
                algorithmNameLabel.setText("Error Default,InsertionSort:");
                System.out.print("algorithm switcher defaulting to insertion sort, parameter error");
        }
        sortingAlgorythm.sort(sortingArray);
        displaySortingArray();

    }

    private void resetSortingArray() {
        sortingArray = Arrays.copyOf(unsortedArray, unsortedArray.length); // clones unsorted to prevent modification of unsorted array.
    }

    private void displayUnsortedArray() {
        unsortedArrayLabel.setText(Arrays.toString(unsortedArray));
    }

    private void displaySortingArray(){
        //todo make a teaching sort operations stack for bottom pane,
        sortedArrayLabel.setText(Arrays.toString(sortingArray));
    }
}
